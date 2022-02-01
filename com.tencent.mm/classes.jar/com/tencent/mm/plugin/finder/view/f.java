package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.am;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.findersdk.d.a.a.b;
import com.tencent.mm.ui.MMFragmentActivity;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "", "()V", "scene", "", "safeMode", "", "onCloseDrawerCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "(IZLcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;)V", "context", "Lcom/tencent/mm/ui/MMFragmentActivity;", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "drawerCreateData", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerCreateData;", "drawerOpenData", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerOpenData;", "fromMsg", "mentionCreateTime", "mentionId", "", "closeDrawer", "", "getDrawer", "isDrawerOpen", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onDetach", "onUIPause", "onUIResume", "openDrawer", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isSingleMode", "refCommentId", "blinkRefComment", "showFooter", "replyCommentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "banSwitch", "reason", "Companion", "plugin-finder_release"})
public final class f
{
  private static final ConcurrentHashMap<Long, o<f.a.a, f.a.b>> AVs;
  private static final ConcurrentHashMap<Long, f.a.c> AVt;
  public static final a AVu;
  private MMFragmentActivity AVp;
  private final f.a.a AVq;
  private f.a.b AVr;
  private boolean xLQ;
  private int xLR;
  private long xcD;
  private CommentDrawerContract.CloseDrawerCallback xwI;
  public FinderCommentDrawer xwQ;
  
  static
  {
    AppMethodBeat.i(280860);
    AVu = new a((byte)0);
    AVs = new ConcurrentHashMap();
    AVt = new ConcurrentHashMap();
    AppMethodBeat.o(280860);
  }
  
  public f()
  {
    this.AVq = null;
  }
  
  private f(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(280859);
    this.AVq = new f.a.a(paramInt, paramBoolean);
    AppMethodBeat.o(280859);
  }
  
  public final void a(FinderItem paramFinderItem, boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3, am paramam, boolean paramBoolean4, int paramInt, CommentDrawerContract.CloseDrawerCallback paramCloseDrawerCallback)
  {
    AppMethodBeat.i(280848);
    p.k(paramFinderItem, "feedObj");
    this.xwI = paramCloseDrawerCallback;
    Object localObject = d.AjH;
    if (((Number)d.dTG().aSr()).intValue() == 1)
    {
      paramCloseDrawerCallback = com.tencent.mm.plugin.finder.utils.aj.AGc;
      localObject = this.AVq;
      paramCloseDrawerCallback = this.AVp;
      if ((localObject != null) && (paramCloseDrawerCallback != null))
      {
        this.AVr = new f.a.b(paramFinderItem, paramBoolean1, paramLong, paramBoolean2, paramBoolean3, paramam);
        paramLong = System.currentTimeMillis();
        paramFinderItem = (Map)AVs;
        paramam = this.AVr;
        if (paramam == null) {
          p.bGy("drawerOpenData");
        }
        paramFinderItem.put(Long.valueOf(paramLong), new o(localObject, paramam));
        paramFinderItem = new Intent();
        paramFinderItem.putExtra("COMMENT_REQUEST_KEY", paramLong);
        paramFinderItem.putExtra("FROM_MSG", this.xLQ);
        paramFinderItem.putExtra("MENTION_ID", this.xcD);
        paramFinderItem.putExtra("MENTION_CREATE_TIME", this.xLR);
        paramam = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        aj.a.a((Context)paramCloseDrawerCallback, paramFinderItem, 0L, 0, false, 124);
        paramam = a.ACH;
        a.a(paramCloseDrawerCallback, paramFinderItem);
        AppMethodBeat.o(280848);
      }
    }
    else
    {
      localObject = this.xwQ;
      if (localObject != null) {
        ((FinderCommentDrawer)localObject).setOnCloseDrawerCallback(paramCloseDrawerCallback);
      }
      paramCloseDrawerCallback = this.xwQ;
      if (paramCloseDrawerCallback != null)
      {
        FinderCommentDrawer.a(paramCloseDrawerCallback, paramFinderItem, paramBoolean1, paramLong, paramBoolean2, paramBoolean3, paramam, paramBoolean4, paramInt, 64);
        AppMethodBeat.o(280848);
        return;
      }
    }
    AppMethodBeat.o(280848);
  }
  
  public final void d(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(280856);
    Object localObject = d.AjH;
    if ((((Number)d.dTG().aSr()).intValue() == 1) && (paramInt == 500) && (paramIntent != null))
    {
      paramIntent = a.ay(paramIntent);
      if (paramIntent != null)
      {
        localObject = this.xwI;
        if (localObject != null)
        {
          ((CommentDrawerContract.CloseDrawerCallback)localObject).i(paramIntent.commentCount, paramIntent.tYs);
          AppMethodBeat.o(280856);
          return;
        }
        AppMethodBeat.o(280856);
        return;
      }
    }
    AppMethodBeat.o(280856);
  }
  
  public final void eir()
  {
    AppMethodBeat.i(280851);
    FinderCommentDrawer localFinderCommentDrawer = this.xwQ;
    if (localFinderCommentDrawer != null)
    {
      localFinderCommentDrawer.eir();
      AppMethodBeat.o(280851);
      return;
    }
    AppMethodBeat.o(280851);
  }
  
  public final boolean eis()
  {
    AppMethodBeat.i(280852);
    FinderCommentDrawer localFinderCommentDrawer = this.xwQ;
    if (localFinderCommentDrawer != null)
    {
      boolean bool = localFinderCommentDrawer.eis();
      AppMethodBeat.o(280852);
      return bool;
    }
    AppMethodBeat.o(280852);
    return false;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(280855);
    FinderCommentDrawer localFinderCommentDrawer = this.xwQ;
    if (localFinderCommentDrawer != null)
    {
      localFinderCommentDrawer.ejF();
      AppMethodBeat.o(280855);
      return;
    }
    AppMethodBeat.o(280855);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(280854);
    FinderCommentDrawer localFinderCommentDrawer = this.xwQ;
    if (localFinderCommentDrawer != null)
    {
      localFinderCommentDrawer.eiv();
      AppMethodBeat.o(280854);
      return;
    }
    AppMethodBeat.o(280854);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion;", "", "()V", "COMMENT_REQUEST_KEY", "", "COMMENT_RESULT_KEY", "FROM_MSG", "MENTION_CREATE_TIME", "MENTION_ID", "REQ_CODE", "", "TAG", "drawerRequestMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerCreateData;", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerOpenData;", "drawerResultMap", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerResultData;", "createDrawerForMsg", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "mentionId", "mentionCreateTime", "context", "Lcom/tencent/mm/ui/MMFragmentActivity;", "scene", "commentScene", "safeMode", "", "createDrawerToAttachWindow", "parent", "Landroid/view/View;", "exposeScene", "fromMsg", "intent", "Landroid/content/Intent;", "getDrawerRequestData", "getDrawerResultData", "getMentionCreateTime", "getMentionId", "putDrawerResultData", "", "resultData", "DrawerCreateData", "DrawerOpenData", "DrawerResultData", "plugin-finder_release"})
  public static final class a
  {
    private static f a(long paramLong, int paramInt1, MMFragmentActivity paramMMFragmentActivity, int paramInt2)
    {
      AppMethodBeat.i(283729);
      p.k(paramMMFragmentActivity, "context");
      f localf = new f(paramInt2, false, (byte)0);
      f.a(localf, paramLong);
      f.a(localf, paramInt1);
      f.a(localf, paramMMFragmentActivity);
      f.a(localf, null);
      f.a(localf);
      AppMethodBeat.o(283729);
      return localf;
    }
    
    public static f a(MMFragmentActivity paramMMFragmentActivity, View paramView, int paramInt1, boolean paramBoolean, int paramInt2)
    {
      AppMethodBeat.i(283727);
      p.k(paramMMFragmentActivity, "context");
      p.k(paramView, "parent");
      paramMMFragmentActivity.getWindow().setSoftInputMode(50);
      f localf = new f(paramInt1, paramBoolean, (byte)0);
      f.a(localf, paramMMFragmentActivity);
      Object localObject = d.AjH;
      if (((Number)d.dTG().aSr()).intValue() == 1) {
        f.a(localf, null);
      }
      for (;;)
      {
        AppMethodBeat.o(283727);
        return localf;
        localObject = FinderCommentDrawer.AVC;
        f.a(localf, FinderCommentDrawer.b.a(paramMMFragmentActivity, paramView, paramInt1, null, paramBoolean, false, paramInt2, 8));
      }
    }
    
    public static f.a.c ay(Intent paramIntent)
    {
      AppMethodBeat.i(283731);
      p.k(paramIntent, "intent");
      long l = paramIntent.getLongExtra("COMMENT_RESULT_KEY", 0L);
      paramIntent = (f.a.c)f.eiu().remove(Long.valueOf(l));
      AppMethodBeat.o(283731);
      return paramIntent;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerOpenData;", "", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isSingleMode", "", "refCommentId", "", "blinkRefComment", "showFooter", "replyCommentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;ZJZZLcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;)V", "getBlinkRefComment", "()Z", "getFeedObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getRefCommentId", "()J", "getReplyCommentObj", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "getShowFooter", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
    public static final class b
    {
      public final boolean AVv;
      public final am AVw;
      public final boolean mss;
      public final long xbT;
      public final FinderItem xwF;
      public final boolean xwM;
      
      public b(FinderItem paramFinderItem, boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3, am paramam)
      {
        AppMethodBeat.i(281554);
        this.xwF = paramFinderItem;
        this.mss = paramBoolean1;
        this.xbT = paramLong;
        this.xwM = paramBoolean2;
        this.AVv = paramBoolean3;
        this.AVw = paramam;
        AppMethodBeat.o(281554);
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(281557);
        if (this != paramObject)
        {
          if ((paramObject instanceof b))
          {
            paramObject = (b)paramObject;
            if ((!p.h(this.xwF, paramObject.xwF)) || (this.mss != paramObject.mss) || (this.xbT != paramObject.xbT) || (this.xwM != paramObject.xwM) || (this.AVv != paramObject.AVv) || (!p.h(this.AVw, paramObject.AVw))) {}
          }
        }
        else
        {
          AppMethodBeat.o(281557);
          return true;
        }
        AppMethodBeat.o(281557);
        return false;
      }
      
      public final int hashCode()
      {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
      }
      
      public final String toString()
      {
        AppMethodBeat.i(281555);
        String str = "DrawerOpenData(feedObj=" + this.xwF + ", isSingleMode=" + this.mss + ", refCommentId=" + this.xbT + ", blinkRefComment=" + this.xwM + ", showFooter=" + this.AVv + ", replyCommentObj=" + this.AVw + ")";
        AppMethodBeat.o(281555);
        return str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.f
 * JD-Core Version:    0.7.0.1
 */