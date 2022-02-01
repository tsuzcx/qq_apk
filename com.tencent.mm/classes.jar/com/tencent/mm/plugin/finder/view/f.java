package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.au;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import com.tencent.mm.ui.MMFragmentActivity;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "", "()V", "scene", "", "safeMode", "", "onCloseDrawerCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "(IZLcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;)V", "context", "Lcom/tencent/mm/ui/MMFragmentActivity;", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "drawerCreateData", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerCreateData;", "drawerOpenData", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerOpenData;", "fromMsg", "mentionCreateTime", "mentionId", "", "closeDrawer", "", "getDrawer", "isDrawerOpen", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onDetach", "onUIPause", "onUIResume", "openDrawer", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isSingleMode", "refCommentId", "blinkRefComment", "showFooter", "replyCommentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "banSwitch", "reason", "isOnlyShowDesc", "blinkDuration", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  private static final ConcurrentHashMap<Long, r<f.a.a, f.a.b>> FYF;
  private static final ConcurrentHashMap<Long, f.a.c> FYG;
  public static final a GxF;
  private long ABR;
  private CommentDrawerContract.CloseDrawerCallback AUm;
  public FinderCommentDrawer AUv;
  private boolean BlY;
  private int BlZ;
  private MMFragmentActivity FYB;
  private final f.a.a GxG;
  private f.a.b GxH;
  
  static
  {
    AppMethodBeat.i(344755);
    GxF = new a((byte)0);
    FYF = new ConcurrentHashMap();
    FYG = new ConcurrentHashMap();
    AppMethodBeat.o(344755);
  }
  
  public f()
  {
    this.GxG = null;
  }
  
  private f(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(344648);
    this.GxG = new f.a.a(paramInt, paramBoolean);
    AppMethodBeat.o(344648);
  }
  
  public final void a(FinderItem paramFinderItem, boolean paramBoolean1, long paramLong1, boolean paramBoolean2, boolean paramBoolean3, au paramau, boolean paramBoolean4, int paramInt, CommentDrawerContract.CloseDrawerCallback paramCloseDrawerCallback, boolean paramBoolean5, long paramLong2)
  {
    AppMethodBeat.i(344778);
    s.u(paramFinderItem, "feedObj");
    this.AUm = paramCloseDrawerCallback;
    Object localObject1 = d.FAy;
    if (((Number)d.eRX().bmg()).intValue() == 1)
    {
      paramCloseDrawerCallback = av.GiL;
      localObject1 = this.GxG;
      paramCloseDrawerCallback = this.FYB;
      Object localObject2 = aw.Gjk;
      if ((localObject1 != null) && (paramCloseDrawerCallback != null))
      {
        this.GxH = new f.a.b(paramFinderItem, paramBoolean1, paramLong1, paramBoolean2, paramBoolean3, paramau);
        paramLong1 = System.currentTimeMillis();
        localObject2 = (Map)FYF;
        paramau = this.GxH;
        paramFinderItem = paramau;
        if (paramau == null)
        {
          s.bIx("drawerOpenData");
          paramFinderItem = null;
        }
        ((Map)localObject2).put(Long.valueOf(paramLong1), new r(localObject1, paramFinderItem));
        paramFinderItem = new Intent();
        paramFinderItem.putExtra("COMMENT_REQUEST_KEY", paramLong1);
        paramFinderItem.putExtra("FROM_MSG", this.BlY);
        paramFinderItem.putExtra("MENTION_ID", this.ABR);
        paramFinderItem.putExtra("MENTION_CREATE_TIME", this.BlZ);
        paramau = as.GSQ;
        as.a.a((Context)paramCloseDrawerCallback, paramFinderItem, 0L, 0, false, 124);
        paramau = a.GfO;
        a.a(paramCloseDrawerCallback, paramFinderItem);
      }
      AppMethodBeat.o(344778);
      return;
    }
    localObject1 = this.AUv;
    if (localObject1 != null) {
      ((FinderCommentDrawer)localObject1).setOnCloseDrawerCallback(paramCloseDrawerCallback);
    }
    paramCloseDrawerCallback = this.AUv;
    if (paramCloseDrawerCallback != null) {
      FinderCommentDrawer.a(paramCloseDrawerCallback, paramFinderItem, paramBoolean1, paramLong1, paramBoolean2, paramBoolean3, paramau, paramBoolean4, paramInt, paramBoolean5, paramLong2, 64);
    }
    AppMethodBeat.o(344778);
  }
  
  public final void fdh()
  {
    AppMethodBeat.i(344788);
    FinderCommentDrawer localFinderCommentDrawer = this.AUv;
    if (localFinderCommentDrawer != null) {
      localFinderCommentDrawer.fdh();
    }
    AppMethodBeat.o(344788);
  }
  
  public final boolean fkp()
  {
    AppMethodBeat.i(344801);
    FinderCommentDrawer localFinderCommentDrawer = this.AUv;
    if (localFinderCommentDrawer == null)
    {
      AppMethodBeat.o(344801);
      return false;
    }
    boolean bool = localFinderCommentDrawer.fkp();
    AppMethodBeat.o(344801);
    return bool;
  }
  
  public final void g(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(344836);
    Object localObject = d.FAy;
    if ((((Number)d.eRX().bmg()).intValue() == 1) && (paramInt == 500) && (paramIntent != null))
    {
      paramIntent = a.aQ(paramIntent);
      if (paramIntent != null)
      {
        localObject = this.AUm;
        if (localObject != null) {
          ((CommentDrawerContract.CloseDrawerCallback)localObject).z(paramIntent.commentCount, paramIntent.bMf);
        }
      }
    }
    AppMethodBeat.o(344836);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(344820);
    FinderCommentDrawer localFinderCommentDrawer = this.AUv;
    if (localFinderCommentDrawer != null) {
      localFinderCommentDrawer.eIv();
    }
    AppMethodBeat.o(344820);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(344810);
    FinderCommentDrawer localFinderCommentDrawer = this.AUv;
    if (localFinderCommentDrawer != null) {
      localFinderCommentDrawer.uU(false);
    }
    AppMethodBeat.o(344810);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion;", "", "()V", "COMMENT_REQUEST_KEY", "", "COMMENT_RESULT_KEY", "FROM_MSG", "MENTION_CREATE_TIME", "MENTION_ID", "REQ_CODE", "", "TAG", "drawerRequestMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerCreateData;", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerOpenData;", "drawerResultMap", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerResultData;", "createDrawerForMsg", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "mentionId", "mentionCreateTime", "context", "Lcom/tencent/mm/ui/MMFragmentActivity;", "scene", "commentScene", "safeMode", "", "createDrawerToAttachWindow", "parent", "Landroid/view/View;", "exposeScene", "fromMsg", "intent", "Landroid/content/Intent;", "getDrawerRequestData", "getDrawerResultData", "getMentionCreateTime", "getMentionId", "putDrawerResultData", "", "resultData", "DrawerCreateData", "DrawerOpenData", "DrawerResultData", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static f a(long paramLong, int paramInt1, MMFragmentActivity paramMMFragmentActivity, int paramInt2)
    {
      AppMethodBeat.i(344913);
      s.u(paramMMFragmentActivity, "context");
      f localf = new f(paramInt2, false, (byte)0);
      f.a(localf, paramLong);
      f.a(localf, paramInt1);
      f.a(localf, paramMMFragmentActivity);
      f.a(localf, null);
      f.a(localf);
      AppMethodBeat.o(344913);
      return localf;
    }
    
    public static f a(MMFragmentActivity paramMMFragmentActivity, View paramView, int paramInt1, boolean paramBoolean, int paramInt2)
    {
      AppMethodBeat.i(344886);
      s.u(paramMMFragmentActivity, "context");
      s.u(paramView, "parent");
      paramMMFragmentActivity.getWindow().setSoftInputMode(50);
      f localf = new f(paramInt1, paramBoolean, (byte)0);
      f.a(localf, paramMMFragmentActivity);
      Object localObject = d.FAy;
      if (((Number)d.eRX().bmg()).intValue() == 1) {
        f.a(localf, null);
      }
      for (;;)
      {
        AppMethodBeat.o(344886);
        return localf;
        localObject = FinderCommentDrawer.GxJ;
        f.a(localf, FinderCommentDrawer.b.a(paramMMFragmentActivity, paramView, paramInt1, null, paramBoolean, false, paramInt2, 8));
      }
    }
    
    public static f.a.c aQ(Intent paramIntent)
    {
      AppMethodBeat.i(344936);
      s.u(paramIntent, "intent");
      long l = paramIntent.getLongExtra("COMMENT_RESULT_KEY", 0L);
      paramIntent = (f.a.c)f.fkr().remove(Long.valueOf(l));
      AppMethodBeat.o(344936);
      return paramIntent;
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerOpenData;", "", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isSingleMode", "", "refCommentId", "", "blinkRefComment", "showFooter", "replyCommentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;ZJZZLcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;)V", "getBlinkRefComment", "()Z", "getFeedObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getRefCommentId", "()J", "getReplyCommentObj", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "getShowFooter", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
    {
      public final long AAW;
      public final FinderItem AUj;
      public final boolean AUq;
      public final boolean FYI;
      public final au GxI;
      public final boolean plm;
      
      public b(FinderItem paramFinderItem, boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3, au paramau)
      {
        AppMethodBeat.i(344532);
        this.AUj = paramFinderItem;
        this.plm = paramBoolean1;
        this.AAW = paramLong;
        this.AUq = paramBoolean2;
        this.FYI = paramBoolean3;
        this.GxI = paramau;
        AppMethodBeat.o(344532);
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(344558);
        if (this == paramObject)
        {
          AppMethodBeat.o(344558);
          return true;
        }
        if (!(paramObject instanceof b))
        {
          AppMethodBeat.o(344558);
          return false;
        }
        paramObject = (b)paramObject;
        if (!s.p(this.AUj, paramObject.AUj))
        {
          AppMethodBeat.o(344558);
          return false;
        }
        if (this.plm != paramObject.plm)
        {
          AppMethodBeat.o(344558);
          return false;
        }
        if (this.AAW != paramObject.AAW)
        {
          AppMethodBeat.o(344558);
          return false;
        }
        if (this.AUq != paramObject.AUq)
        {
          AppMethodBeat.o(344558);
          return false;
        }
        if (this.FYI != paramObject.FYI)
        {
          AppMethodBeat.o(344558);
          return false;
        }
        if (!s.p(this.GxI, paramObject.GxI))
        {
          AppMethodBeat.o(344558);
          return false;
        }
        AppMethodBeat.o(344558);
        return true;
      }
      
      public final int hashCode()
      {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
      }
      
      public final String toString()
      {
        AppMethodBeat.i(344541);
        String str = "DrawerOpenData(feedObj=" + this.AUj + ", isSingleMode=" + this.plm + ", refCommentId=" + this.AAW + ", blinkRefComment=" + this.AUq + ", showFooter=" + this.FYI + ", replyCommentObj=" + this.GxI + ')';
        AppMethodBeat.o(344541);
        return str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.f
 * JD-Core Version:    0.7.0.1
 */