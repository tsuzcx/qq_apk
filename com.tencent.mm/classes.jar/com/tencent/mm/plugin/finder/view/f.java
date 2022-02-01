package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.h;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.utils.i;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.ui.MMActivity;
import d.l;
import d.o;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "", "()V", "scene", "", "safeMode", "", "onCloseDrawerCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "(IZLcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;)V", "context", "Lcom/tencent/mm/ui/MMActivity;", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "drawerCreateData", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerCreateData;", "drawerOpenData", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerOpenData;", "fromMsg", "mentionId", "", "closeDrawer", "", "getDrawer", "isDrawerOpen", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onUIPause", "onUIResume", "openDrawer", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isSingleMode", "refCommentId", "blinkRefComment", "showFooter", "replyCommentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "Companion", "plugin-finder_release"})
public final class f
{
  private static final ConcurrentHashMap<Long, o<f.a.a, f.a.b>> LeC;
  private static final ConcurrentHashMap<Long, f.a.c> LeD;
  public static final a LeE;
  public FinderCommentDrawer KRi;
  private boolean KRl;
  private final f.a.a LeA;
  private f.a.b LeB;
  private MMActivity imP;
  private long qNU;
  private CommentDrawerContract.CloseDrawerCallback qux;
  
  static
  {
    AppMethodBeat.i(200057);
    LeE = new a((byte)0);
    LeC = new ConcurrentHashMap();
    LeD = new ConcurrentHashMap();
    AppMethodBeat.o(200057);
  }
  
  public f()
  {
    this.LeA = null;
  }
  
  private f(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(200056);
    this.LeA = new f.a.a(paramInt, paramBoolean);
    AppMethodBeat.o(200056);
  }
  
  public final void a(FinderItem paramFinderItem, long paramLong, boolean paramBoolean1, boolean paramBoolean2, com.tencent.mm.plugin.finder.storage.k paramk, CommentDrawerContract.CloseDrawerCallback paramCloseDrawerCallback)
  {
    AppMethodBeat.i(200050);
    d.g.b.k.h(paramFinderItem, "feedObj");
    this.qux = paramCloseDrawerCallback;
    Object localObject = b.qJA;
    if (b.fUp())
    {
      paramCloseDrawerCallback = i.qTa;
      localObject = this.LeA;
      paramCloseDrawerCallback = this.imP;
      if ((localObject != null) && (paramCloseDrawerCallback != null))
      {
        this.LeB = new f.a.b(paramFinderItem, paramLong, paramBoolean1, paramBoolean2, paramk);
        paramLong = System.currentTimeMillis();
        paramFinderItem = (Map)LeC;
        paramk = this.LeB;
        if (paramk == null) {
          d.g.b.k.aPZ("drawerOpenData");
        }
        paramFinderItem.put(Long.valueOf(paramLong), new o(localObject, paramk));
        paramFinderItem = new Intent();
        paramFinderItem.putExtra("COMMENT_REQUEST_KEY", paramLong);
        paramFinderItem.putExtra("FROM_MSG", this.KRl);
        paramFinderItem.putExtra("MENTION_ID", this.qNU);
        paramk = FinderReporterUIC.Ljl;
        FinderReporterUIC.a.a((Context)paramCloseDrawerCallback, paramFinderItem, 0L, 0, false, 124);
        paramk = a.qSb;
        a.c(paramCloseDrawerCallback, paramFinderItem);
      }
      AppMethodBeat.o(200050);
      return;
    }
    localObject = this.KRi;
    if (localObject != null) {
      ((FinderCommentDrawer)localObject).setOnCloseDrawerCallback(paramCloseDrawerCallback);
    }
    paramCloseDrawerCallback = this.KRi;
    if (paramCloseDrawerCallback != null)
    {
      FinderCommentDrawer.a(paramCloseDrawerCallback, paramFinderItem, paramLong, paramBoolean1, paramBoolean2, paramk);
      AppMethodBeat.o(200050);
      return;
    }
    AppMethodBeat.o(200050);
  }
  
  public final void csJ()
  {
    AppMethodBeat.i(200052);
    FinderCommentDrawer localFinderCommentDrawer = this.KRi;
    if (localFinderCommentDrawer != null)
    {
      localFinderCommentDrawer.csJ();
      AppMethodBeat.o(200052);
      return;
    }
    AppMethodBeat.o(200052);
  }
  
  public final boolean fiQ()
  {
    AppMethodBeat.i(200053);
    FinderCommentDrawer localFinderCommentDrawer = this.KRi;
    if (localFinderCommentDrawer != null)
    {
      boolean bool = localFinderCommentDrawer.fiQ();
      AppMethodBeat.o(200053);
      return bool;
    }
    AppMethodBeat.o(200053);
    return false;
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(200054);
    FinderCommentDrawer localFinderCommentDrawer = this.KRi;
    if (localFinderCommentDrawer != null)
    {
      localFinderCommentDrawer.csI();
      AppMethodBeat.o(200054);
      return;
    }
    AppMethodBeat.o(200054);
  }
  
  public final void r(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(200055);
    Object localObject = b.qJA;
    if ((b.fUp()) && (paramInt == 500) && (paramIntent != null))
    {
      paramIntent = a.bv(paramIntent);
      if (paramIntent != null)
      {
        localObject = this.qux;
        if (localObject != null)
        {
          ((CommentDrawerContract.CloseDrawerCallback)localObject).o(paramIntent.commentCount, paramIntent.nWL);
          AppMethodBeat.o(200055);
          return;
        }
        AppMethodBeat.o(200055);
        return;
      }
    }
    AppMethodBeat.o(200055);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion;", "", "()V", "COMMENT_REQUEST_KEY", "", "COMMENT_RESULT_KEY", "FROM_MSG", "MENTION_ID", "REQ_CODE", "", "TAG", "drawerRequestMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerCreateData;", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerOpenData;", "drawerResultMap", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerResultData;", "createDrawerForMsg", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "mentionId", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "commentScene", "safeMode", "", "createDrawerToAttachWindow", "parent", "Landroid/view/View;", "fromMsg", "intent", "Landroid/content/Intent;", "getDrawerRequestData", "getDrawerResultData", "getMentionId", "putDrawerResultData", "", "resultData", "DrawerCreateData", "DrawerOpenData", "DrawerResultData", "plugin-finder_release"})
  public static final class a
  {
    public static f a(MMActivity paramMMActivity, View paramView, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(200048);
      d.g.b.k.h(paramMMActivity, "context");
      d.g.b.k.h(paramView, "parent");
      f localf = new f(paramInt, paramBoolean, (byte)0);
      f.a(localf, paramMMActivity);
      Object localObject = b.qJA;
      if (b.fUp()) {
        f.a(localf, null);
      }
      for (;;)
      {
        AppMethodBeat.o(200048);
        return localf;
        localObject = FinderCommentDrawer.qVJ;
        f.a(localf, FinderCommentDrawer.b.b(paramMMActivity, paramView, paramInt, paramBoolean));
      }
    }
    
    public static c bv(Intent paramIntent)
    {
      AppMethodBeat.i(200049);
      d.g.b.k.h(paramIntent, "intent");
      long l = paramIntent.getLongExtra("COMMENT_RESULT_KEY", 0L);
      paramIntent = (c)f.fWH().remove(Long.valueOf(l));
      AppMethodBeat.o(200049);
      return paramIntent;
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerCreateData;", "", "scene", "", "safeMode", "", "(IZ)V", "getSafeMode", "()Z", "getScene", "()I", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "plugin-finder_release"})
    public static final class a
    {
      public final boolean qqF;
      public final int scene;
      
      public a(int paramInt, boolean paramBoolean)
      {
        this.scene = paramInt;
        this.qqF = paramBoolean;
      }
      
      public final boolean equals(Object paramObject)
      {
        if (this != paramObject)
        {
          if ((paramObject instanceof a))
          {
            paramObject = (a)paramObject;
            if ((this.scene != paramObject.scene) || (this.qqF != paramObject.qqF)) {}
          }
        }
        else {
          return true;
        }
        return false;
      }
      
      public final int hashCode()
      {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
      }
      
      public final String toString()
      {
        AppMethodBeat.i(200039);
        String str = "DrawerCreateData(scene=" + this.scene + ", safeMode=" + this.qqF + ")";
        AppMethodBeat.o(200039);
        return str;
      }
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerOpenData;", "", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isSingleMode", "", "refCommentId", "", "blinkRefComment", "showFooter", "replyCommentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;ZJZZLcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;)V", "getBlinkRefComment", "()Z", "getFeedObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getRefCommentId", "()J", "getReplyCommentObj", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "getShowFooter", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
    public static final class b
    {
      public final boolean qVF;
      public final com.tencent.mm.plugin.finder.storage.k qVH;
      public final long qoE;
      public final boolean quB;
      public final boolean quC;
      public final FinderItem quu;
      
      public b(FinderItem paramFinderItem, long paramLong, boolean paramBoolean1, boolean paramBoolean2, com.tencent.mm.plugin.finder.storage.k paramk)
      {
        AppMethodBeat.i(200040);
        this.quu = paramFinderItem;
        this.quB = false;
        this.qoE = paramLong;
        this.quC = paramBoolean1;
        this.qVF = paramBoolean2;
        this.qVH = paramk;
        AppMethodBeat.o(200040);
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(200043);
        if (this != paramObject)
        {
          if ((paramObject instanceof b))
          {
            paramObject = (b)paramObject;
            if ((!d.g.b.k.g(this.quu, paramObject.quu)) || (this.quB != paramObject.quB) || (this.qoE != paramObject.qoE) || (this.quC != paramObject.quC) || (this.qVF != paramObject.qVF) || (!d.g.b.k.g(this.qVH, paramObject.qVH))) {}
          }
        }
        else
        {
          AppMethodBeat.o(200043);
          return true;
        }
        AppMethodBeat.o(200043);
        return false;
      }
      
      public final int hashCode()
      {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
      }
      
      public final String toString()
      {
        AppMethodBeat.i(200041);
        String str = "DrawerOpenData(feedObj=" + this.quu + ", isSingleMode=" + this.quB + ", refCommentId=" + this.qoE + ", blinkRefComment=" + this.quC + ", showFooter=" + this.qVF + ", replyCommentObj=" + this.qVH + ")";
        AppMethodBeat.o(200041);
        return str;
      }
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerResultData;", "", "commentCount", "", "data", "", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "(ILjava/util/List;)V", "getCommentCount", "()I", "getData", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
    public static final class c
    {
      final int commentCount;
      final List<h> nWL;
      
      public c(int paramInt, List<? extends h> paramList)
      {
        AppMethodBeat.i(200044);
        this.commentCount = paramInt;
        this.nWL = paramList;
        AppMethodBeat.o(200044);
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(200047);
        if (this != paramObject)
        {
          if ((paramObject instanceof c))
          {
            paramObject = (c)paramObject;
            if ((this.commentCount != paramObject.commentCount) || (!d.g.b.k.g(this.nWL, paramObject.nWL))) {}
          }
        }
        else
        {
          AppMethodBeat.o(200047);
          return true;
        }
        AppMethodBeat.o(200047);
        return false;
      }
      
      public final int hashCode()
      {
        AppMethodBeat.i(200046);
        int j = this.commentCount;
        List localList = this.nWL;
        if (localList != null) {}
        for (int i = localList.hashCode();; i = 0)
        {
          AppMethodBeat.o(200046);
          return i + j * 31;
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(200045);
        String str = "DrawerResultData(commentCount=" + this.commentCount + ", data=" + this.nWL + ")";
        AppMethodBeat.o(200045);
        return str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.f
 * JD-Core Version:    0.7.0.1
 */