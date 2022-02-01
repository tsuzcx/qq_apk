package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.ui.MMActivity;
import d.l;
import d.o;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "", "()V", "scene", "", "safeMode", "", "onCloseDrawerCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "(IZLcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;)V", "context", "Lcom/tencent/mm/ui/MMActivity;", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "drawerCreateData", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerCreateData;", "drawerOpenData", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerOpenData;", "fromMsg", "mentionCreateTime", "mentionId", "", "closeDrawer", "", "getDrawer", "isDrawerOpen", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onDetach", "onUIPause", "onUIResume", "openDrawer", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isSingleMode", "refCommentId", "blinkRefComment", "showFooter", "replyCommentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "banSwitch", "reason", "Companion", "plugin-finder_release"})
public final class e
{
  public static final a sSA;
  private static final ConcurrentHashMap<Long, o<e.a.a, e.a.b>> sSy;
  private static final ConcurrentHashMap<Long, e.a.c> sSz;
  private MMActivity fLP;
  private CommentDrawerContract.CloseDrawerCallback rUG;
  private final e.a.a sSw;
  private e.a.b sSx;
  private boolean sdA;
  private long sdB;
  private int sdC;
  public FinderCommentDrawer sdx;
  
  static
  {
    AppMethodBeat.i(205084);
    sSA = new a((byte)0);
    sSy = new ConcurrentHashMap();
    sSz = new ConcurrentHashMap();
    AppMethodBeat.o(205084);
  }
  
  public e()
  {
    this.sSw = null;
  }
  
  private e(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(205083);
    this.sSw = new e.a.a(paramInt, paramBoolean);
    AppMethodBeat.o(205083);
  }
  
  public final void a(FinderItem paramFinderItem, boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3, ab paramab, boolean paramBoolean4, int paramInt, CommentDrawerContract.CloseDrawerCallback paramCloseDrawerCallback)
  {
    AppMethodBeat.i(221565);
    d.g.b.p.h(paramFinderItem, "feedObj");
    this.rUG = paramCloseDrawerCallback;
    Object localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
    if (((Number)com.tencent.mm.plugin.finder.storage.b.cGM().value()).intValue() == 1)
    {
      paramCloseDrawerCallback = com.tencent.mm.plugin.finder.utils.p.sMo;
      localObject = this.sSw;
      paramCloseDrawerCallback = this.fLP;
      if ((localObject != null) && (paramCloseDrawerCallback != null))
      {
        this.sSx = new e.a.b(paramFinderItem, paramBoolean1, paramLong, paramBoolean2, paramBoolean3, paramab);
        paramLong = System.currentTimeMillis();
        paramFinderItem = (Map)sSy;
        paramab = this.sSx;
        if (paramab == null) {
          d.g.b.p.bcb("drawerOpenData");
        }
        paramFinderItem.put(Long.valueOf(paramLong), new o(localObject, paramab));
        paramFinderItem = new Intent();
        paramFinderItem.putExtra("COMMENT_REQUEST_KEY", paramLong);
        paramFinderItem.putExtra("FROM_MSG", this.sdA);
        paramFinderItem.putExtra("MENTION_ID", this.sdB);
        paramFinderItem.putExtra("MENTION_CREATE_TIME", this.sdC);
        paramab = FinderReporterUIC.tcM;
        FinderReporterUIC.a.a((Context)paramCloseDrawerCallback, paramFinderItem, 0L, 0, false, 124);
        paramab = a.sKD;
        a.c(paramCloseDrawerCallback, paramFinderItem);
        AppMethodBeat.o(221565);
      }
    }
    else
    {
      localObject = this.sdx;
      if (localObject != null) {
        ((FinderCommentDrawer)localObject).setOnCloseDrawerCallback(paramCloseDrawerCallback);
      }
      paramCloseDrawerCallback = this.sdx;
      if (paramCloseDrawerCallback != null)
      {
        FinderCommentDrawer.a(paramCloseDrawerCallback, paramFinderItem, paramBoolean1, paramLong, paramBoolean2, paramBoolean3, paramab, paramBoolean4, paramInt, 64);
        AppMethodBeat.o(221565);
        return;
      }
    }
    AppMethodBeat.o(221565);
  }
  
  public final void cMY()
  {
    AppMethodBeat.i(205078);
    FinderCommentDrawer localFinderCommentDrawer = this.sdx;
    if (localFinderCommentDrawer != null)
    {
      localFinderCommentDrawer.cMY();
      AppMethodBeat.o(205078);
      return;
    }
    AppMethodBeat.o(205078);
  }
  
  public final boolean cMZ()
  {
    AppMethodBeat.i(205079);
    FinderCommentDrawer localFinderCommentDrawer = this.sdx;
    if (localFinderCommentDrawer != null)
    {
      boolean bool = localFinderCommentDrawer.cMZ();
      AppMethodBeat.o(205079);
      return bool;
    }
    AppMethodBeat.o(205079);
    return false;
  }
  
  public final void d(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(205082);
    Object localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
    if ((((Number)com.tencent.mm.plugin.finder.storage.b.cGM().value()).intValue() == 1) && (paramInt == 500) && (paramIntent != null))
    {
      paramIntent = a.am(paramIntent);
      if (paramIntent != null)
      {
        localObject = this.rUG;
        if (localObject != null)
        {
          ((CommentDrawerContract.CloseDrawerCallback)localObject).g(paramIntent.commentCount, paramIntent.pdB);
          AppMethodBeat.o(205082);
          return;
        }
        AppMethodBeat.o(205082);
        return;
      }
    }
    AppMethodBeat.o(205082);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(205081);
    FinderCommentDrawer localFinderCommentDrawer = this.sdx;
    if (localFinderCommentDrawer != null)
    {
      localFinderCommentDrawer.cNK();
      AppMethodBeat.o(205081);
      return;
    }
    AppMethodBeat.o(205081);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(205080);
    FinderCommentDrawer localFinderCommentDrawer = this.sdx;
    if (localFinderCommentDrawer != null)
    {
      localFinderCommentDrawer.cNc();
      AppMethodBeat.o(205080);
      return;
    }
    AppMethodBeat.o(205080);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion;", "", "()V", "COMMENT_REQUEST_KEY", "", "COMMENT_RESULT_KEY", "FROM_MSG", "MENTION_CREATE_TIME", "MENTION_ID", "REQ_CODE", "", "TAG", "drawerRequestMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerCreateData;", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerOpenData;", "drawerResultMap", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerResultData;", "createDrawerForMsg", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "mentionId", "mentionCreateTime", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "commentScene", "safeMode", "", "createDrawerToAttachWindow", "parent", "Landroid/view/View;", "fromMsg", "intent", "Landroid/content/Intent;", "getDrawerRequestData", "getDrawerResultData", "getMentionCreateTime", "getMentionId", "putDrawerResultData", "", "resultData", "DrawerCreateData", "DrawerOpenData", "DrawerResultData", "plugin-finder_release"})
  public static final class a
  {
    public static e a(MMActivity paramMMActivity, View paramView, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(205074);
      d.g.b.p.h(paramMMActivity, "context");
      d.g.b.p.h(paramView, "parent");
      paramMMActivity.getWindow().setSoftInputMode(50);
      e locale = new e(paramInt, paramBoolean, (byte)0);
      e.a(locale, paramMMActivity);
      Object localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cGM().value()).intValue() == 1) {
        e.a(locale, null);
      }
      for (;;)
      {
        AppMethodBeat.o(205074);
        return locale;
        localObject = FinderCommentDrawer.sSJ;
        e.a(locale, FinderCommentDrawer.b.b(paramMMActivity, paramView, paramInt, paramBoolean));
      }
    }
    
    public static e.a.c am(Intent paramIntent)
    {
      AppMethodBeat.i(205075);
      d.g.b.p.h(paramIntent, "intent");
      long l = paramIntent.getLongExtra("COMMENT_RESULT_KEY", 0L);
      paramIntent = (e.a.c)e.cNb().remove(Long.valueOf(l));
      AppMethodBeat.o(205075);
      return paramIntent;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerOpenData;", "", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isSingleMode", "", "refCommentId", "", "blinkRefComment", "showFooter", "replyCommentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;ZJZZLcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;)V", "getBlinkRefComment", "()Z", "getFeedObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getRefCommentId", "()J", "getReplyCommentObj", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "getShowFooter", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
    public static final class b
    {
      public final long rIH;
      public final boolean rUK;
      public final boolean rUL;
      public final FinderItem rUg;
      public final boolean sSB;
      public final ab sSC;
      
      public b(FinderItem paramFinderItem, boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3, ab paramab)
      {
        AppMethodBeat.i(221564);
        this.rUg = paramFinderItem;
        this.rUK = paramBoolean1;
        this.rIH = paramLong;
        this.rUL = paramBoolean2;
        this.sSB = paramBoolean3;
        this.sSC = paramab;
        AppMethodBeat.o(221564);
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(205069);
        if (this != paramObject)
        {
          if ((paramObject instanceof b))
          {
            paramObject = (b)paramObject;
            if ((!d.g.b.p.i(this.rUg, paramObject.rUg)) || (this.rUK != paramObject.rUK) || (this.rIH != paramObject.rIH) || (this.rUL != paramObject.rUL) || (this.sSB != paramObject.sSB) || (!d.g.b.p.i(this.sSC, paramObject.sSC))) {}
          }
        }
        else
        {
          AppMethodBeat.o(205069);
          return true;
        }
        AppMethodBeat.o(205069);
        return false;
      }
      
      public final int hashCode()
      {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
      }
      
      public final String toString()
      {
        AppMethodBeat.i(205067);
        String str = "DrawerOpenData(feedObj=" + this.rUg + ", isSingleMode=" + this.rUK + ", refCommentId=" + this.rIH + ", blinkRefComment=" + this.rUL + ", showFooter=" + this.sSB + ", replyCommentObj=" + this.sSC + ")";
        AppMethodBeat.o(205067);
        return str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.e
 * JD-Core Version:    0.7.0.1
 */