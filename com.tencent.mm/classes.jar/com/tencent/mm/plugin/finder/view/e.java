package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.storage.config.b;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.ui.MMFragmentActivity;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "", "()V", "scene", "", "safeMode", "", "onCloseDrawerCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "(IZLcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;)V", "context", "Lcom/tencent/mm/ui/MMFragmentActivity;", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "drawerCreateData", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerCreateData;", "drawerOpenData", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerOpenData;", "fromMsg", "mentionCreateTime", "mentionId", "", "closeDrawer", "", "getDrawer", "isDrawerOpen", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onDetach", "onUIPause", "onUIResume", "openDrawer", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isSingleMode", "refCommentId", "blinkRefComment", "showFooter", "replyCommentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "banSwitch", "reason", "Companion", "plugin-finder_release"})
public final class e
{
  private static final ConcurrentHashMap<Long, o<e.a.a, e.a.b>> wkw;
  private static final ConcurrentHashMap<Long, e.a.c> wkx;
  public static final a wky;
  private CommentDrawerContract.CloseDrawerCallback tMR;
  public FinderCommentDrawer tNb;
  private boolean tZA;
  private long tZB;
  private int tZC;
  private MMFragmentActivity wkt;
  private final e.a.a wku;
  private e.a.b wkv;
  
  static
  {
    AppMethodBeat.i(254732);
    wky = new a((byte)0);
    wkw = new ConcurrentHashMap();
    wkx = new ConcurrentHashMap();
    AppMethodBeat.o(254732);
  }
  
  public e()
  {
    this.wku = null;
  }
  
  private e(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(254731);
    this.wku = new e.a.a(paramInt, paramBoolean);
    AppMethodBeat.o(254731);
  }
  
  public final void a(FinderItem paramFinderItem, boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3, an paraman, boolean paramBoolean4, int paramInt, CommentDrawerContract.CloseDrawerCallback paramCloseDrawerCallback)
  {
    AppMethodBeat.i(254724);
    p.h(paramFinderItem, "feedObj");
    this.tMR = paramCloseDrawerCallback;
    Object localObject = c.vCb;
    if (((Number)c.dsr().value()).intValue() == 1)
    {
      paramCloseDrawerCallback = y.vXH;
      localObject = this.wku;
      paramCloseDrawerCallback = this.wkt;
      if ((localObject != null) && (paramCloseDrawerCallback != null))
      {
        this.wkv = new e.a.b(paramFinderItem, paramBoolean1, paramLong, paramBoolean2, paramBoolean3, paraman);
        paramLong = System.currentTimeMillis();
        paramFinderItem = (Map)wkw;
        paraman = this.wkv;
        if (paraman == null) {
          p.btv("drawerOpenData");
        }
        paramFinderItem.put(Long.valueOf(paramLong), new o(localObject, paraman));
        paramFinderItem = new Intent();
        paramFinderItem.putExtra("COMMENT_REQUEST_KEY", paramLong);
        paramFinderItem.putExtra("FROM_MSG", this.tZA);
        paramFinderItem.putExtra("MENTION_ID", this.tZB);
        paramFinderItem.putExtra("MENTION_CREATE_TIME", this.tZC);
        paraman = FinderReporterUIC.wzC;
        FinderReporterUIC.a.a((Context)paramCloseDrawerCallback, paramFinderItem, 0L, 0, false, 124);
        paraman = a.vUU;
        a.a(paramCloseDrawerCallback, paramFinderItem);
        AppMethodBeat.o(254724);
      }
    }
    else
    {
      localObject = this.tNb;
      if (localObject != null) {
        ((FinderCommentDrawer)localObject).setOnCloseDrawerCallback(paramCloseDrawerCallback);
      }
      paramCloseDrawerCallback = this.tNb;
      if (paramCloseDrawerCallback != null)
      {
        FinderCommentDrawer.a(paramCloseDrawerCallback, paramFinderItem, paramBoolean1, paramLong, paramBoolean2, paramBoolean3, paraman, paramBoolean4, paramInt, 64);
        AppMethodBeat.o(254724);
        return;
      }
    }
    AppMethodBeat.o(254724);
  }
  
  public final void d(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(254730);
    Object localObject = c.vCb;
    if ((((Number)c.dsr().value()).intValue() == 1) && (paramInt == 500) && (paramIntent != null))
    {
      paramIntent = a.at(paramIntent);
      if (paramIntent != null)
      {
        localObject = this.tMR;
        if (localObject != null)
        {
          ((CommentDrawerContract.CloseDrawerCallback)localObject).g(paramIntent.commentCount, paramIntent.qzs);
          AppMethodBeat.o(254730);
          return;
        }
        AppMethodBeat.o(254730);
        return;
      }
    }
    AppMethodBeat.o(254730);
  }
  
  public final void dGr()
  {
    AppMethodBeat.i(254726);
    FinderCommentDrawer localFinderCommentDrawer = this.tNb;
    if (localFinderCommentDrawer != null)
    {
      localFinderCommentDrawer.dGr();
      AppMethodBeat.o(254726);
      return;
    }
    AppMethodBeat.o(254726);
  }
  
  public final boolean dGs()
  {
    AppMethodBeat.i(254727);
    FinderCommentDrawer localFinderCommentDrawer = this.tNb;
    if (localFinderCommentDrawer != null)
    {
      boolean bool = localFinderCommentDrawer.dGs();
      AppMethodBeat.o(254727);
      return bool;
    }
    AppMethodBeat.o(254727);
    return false;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(254729);
    FinderCommentDrawer localFinderCommentDrawer = this.tNb;
    if (localFinderCommentDrawer != null)
    {
      localFinderCommentDrawer.dHu();
      AppMethodBeat.o(254729);
      return;
    }
    AppMethodBeat.o(254729);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(254728);
    FinderCommentDrawer localFinderCommentDrawer = this.tNb;
    if (localFinderCommentDrawer != null)
    {
      localFinderCommentDrawer.dGv();
      AppMethodBeat.o(254728);
      return;
    }
    AppMethodBeat.o(254728);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion;", "", "()V", "COMMENT_REQUEST_KEY", "", "COMMENT_RESULT_KEY", "FROM_MSG", "MENTION_CREATE_TIME", "MENTION_ID", "REQ_CODE", "", "TAG", "drawerRequestMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerCreateData;", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerOpenData;", "drawerResultMap", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerResultData;", "createDrawerForMsg", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "mentionId", "mentionCreateTime", "context", "Lcom/tencent/mm/ui/MMFragmentActivity;", "scene", "commentScene", "safeMode", "", "createDrawerToAttachWindow", "parent", "Landroid/view/View;", "exposeScene", "fromMsg", "intent", "Landroid/content/Intent;", "getDrawerRequestData", "getDrawerResultData", "getMentionCreateTime", "getMentionId", "putDrawerResultData", "", "resultData", "DrawerCreateData", "DrawerOpenData", "DrawerResultData", "plugin-finder_release"})
  public static final class a
  {
    private static e a(long paramLong, int paramInt1, MMFragmentActivity paramMMFragmentActivity, int paramInt2)
    {
      AppMethodBeat.i(254721);
      p.h(paramMMFragmentActivity, "context");
      e locale = new e(paramInt2, false, (byte)0);
      e.a(locale, paramLong);
      e.a(locale, paramInt1);
      e.a(locale, paramMMFragmentActivity);
      e.a(locale, null);
      e.a(locale);
      AppMethodBeat.o(254721);
      return locale;
    }
    
    public static e a(MMFragmentActivity paramMMFragmentActivity, View paramView, int paramInt1, boolean paramBoolean, int paramInt2)
    {
      AppMethodBeat.i(254719);
      p.h(paramMMFragmentActivity, "context");
      p.h(paramView, "parent");
      paramMMFragmentActivity.getWindow().setSoftInputMode(50);
      e locale = new e(paramInt1, paramBoolean, (byte)0);
      e.a(locale, paramMMFragmentActivity);
      Object localObject = c.vCb;
      if (((Number)c.dsr().value()).intValue() == 1) {
        e.a(locale, null);
      }
      for (;;)
      {
        AppMethodBeat.o(254719);
        return locale;
        localObject = FinderCommentDrawer.wkG;
        e.a(locale, FinderCommentDrawer.b.a(paramMMFragmentActivity, paramView, paramInt1, null, paramBoolean, false, paramInt2, 8));
      }
    }
    
    public static e.a.c at(Intent paramIntent)
    {
      AppMethodBeat.i(254723);
      p.h(paramIntent, "intent");
      long l = paramIntent.getLongExtra("COMMENT_RESULT_KEY", 0L);
      paramIntent = (e.a.c)e.dGu().remove(Long.valueOf(l));
      AppMethodBeat.o(254723);
      return paramIntent;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerOpenData;", "", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isSingleMode", "", "refCommentId", "", "blinkRefComment", "showFooter", "replyCommentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;ZJZZLcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;)V", "getBlinkRefComment", "()Z", "getFeedObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getRefCommentId", "()J", "getReplyCommentObj", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "getShowFooter", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
    public static final class b
    {
      public final FinderItem tMO;
      public final boolean tMV;
      public final boolean tMW;
      public final long tuj;
      public final an wkA;
      public final boolean wkz;
      
      public b(FinderItem paramFinderItem, boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3, an paraman)
      {
        AppMethodBeat.i(254711);
        this.tMO = paramFinderItem;
        this.tMV = paramBoolean1;
        this.tuj = paramLong;
        this.tMW = paramBoolean2;
        this.wkz = paramBoolean3;
        this.wkA = paraman;
        AppMethodBeat.o(254711);
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(254714);
        if (this != paramObject)
        {
          if ((paramObject instanceof b))
          {
            paramObject = (b)paramObject;
            if ((!p.j(this.tMO, paramObject.tMO)) || (this.tMV != paramObject.tMV) || (this.tuj != paramObject.tuj) || (this.tMW != paramObject.tMW) || (this.wkz != paramObject.wkz) || (!p.j(this.wkA, paramObject.wkA))) {}
          }
        }
        else
        {
          AppMethodBeat.o(254714);
          return true;
        }
        AppMethodBeat.o(254714);
        return false;
      }
      
      public final int hashCode()
      {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
      }
      
      public final String toString()
      {
        AppMethodBeat.i(254712);
        String str = "DrawerOpenData(feedObj=" + this.tMO + ", isSingleMode=" + this.tMV + ", refCommentId=" + this.tuj + ", blinkRefComment=" + this.tMW + ", showFooter=" + this.wkz + ", replyCommentObj=" + this.wkA + ")";
        AppMethodBeat.o(254712);
        return str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.e
 * JD-Core Version:    0.7.0.1
 */