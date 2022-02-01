package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.plugin.finder.storage.t;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.ui.MMActivity;
import d.g.b.k;
import d.l;
import d.o;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "", "()V", "scene", "", "safeMode", "", "onCloseDrawerCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "(IZLcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;)V", "context", "Lcom/tencent/mm/ui/MMActivity;", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "drawerCreateData", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerCreateData;", "drawerOpenData", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerOpenData;", "fromMsg", "mentionCreateTime", "mentionId", "", "closeDrawer", "", "getDrawer", "isDrawerOpen", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onDetach", "onUIPause", "onUIResume", "openDrawer", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isSingleMode", "refCommentId", "blinkRefComment", "showFooter", "replyCommentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "Companion", "plugin-finder_release"})
public final class d
{
  private static final ConcurrentHashMap<Long, o<d.a.a, d.a.b>> rVP;
  private static final ConcurrentHashMap<Long, d.a.c> rVQ;
  public static final a rVR;
  private MMActivity iMV;
  private final d.a.a rVN;
  private d.a.b rVO;
  private CommentDrawerContract.CloseDrawerCallback rgz;
  public FinderCommentDrawer roO;
  private boolean roR;
  private long roS;
  private int roT;
  
  static
  {
    AppMethodBeat.i(204125);
    rVR = new a((byte)0);
    rVP = new ConcurrentHashMap();
    rVQ = new ConcurrentHashMap();
    AppMethodBeat.o(204125);
  }
  
  public d()
  {
    this.rVN = null;
  }
  
  private d(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(204124);
    this.rVN = new d.a.a(paramInt, paramBoolean);
    AppMethodBeat.o(204124);
  }
  
  public final void a(FinderItem paramFinderItem, long paramLong, boolean paramBoolean, t paramt, CommentDrawerContract.CloseDrawerCallback paramCloseDrawerCallback)
  {
    AppMethodBeat.i(204118);
    k.h(paramFinderItem, "feedObj");
    this.rgz = paramCloseDrawerCallback;
    Object localObject = b.rCU;
    if (b.czM())
    {
      paramCloseDrawerCallback = n.rPN;
      localObject = this.rVN;
      paramCloseDrawerCallback = this.iMV;
      if ((localObject != null) && (paramCloseDrawerCallback != null))
      {
        this.rVO = new d.a.b(paramFinderItem, paramLong, paramBoolean, paramt);
        paramLong = System.currentTimeMillis();
        paramFinderItem = (Map)rVP;
        paramt = this.rVO;
        if (paramt == null) {
          k.aVY("drawerOpenData");
        }
        paramFinderItem.put(Long.valueOf(paramLong), new o(localObject, paramt));
        paramFinderItem = new Intent();
        paramFinderItem.putExtra("COMMENT_REQUEST_KEY", paramLong);
        paramFinderItem.putExtra("FROM_MSG", this.roR);
        paramFinderItem.putExtra("MENTION_ID", this.roS);
        paramFinderItem.putExtra("MENTION_CREATE_TIME", this.roT);
        paramt = FinderReporterUIC.seQ;
        FinderReporterUIC.a.a((Context)paramCloseDrawerCallback, paramFinderItem, 0L, 0, false, 124);
        paramt = a.rOv;
        a.c(paramCloseDrawerCallback, paramFinderItem);
      }
      AppMethodBeat.o(204118);
      return;
    }
    localObject = this.roO;
    if (localObject != null) {
      ((FinderCommentDrawer)localObject).setOnCloseDrawerCallback(paramCloseDrawerCallback);
    }
    paramCloseDrawerCallback = this.roO;
    if (paramCloseDrawerCallback != null)
    {
      FinderCommentDrawer.a(paramCloseDrawerCallback, paramFinderItem, paramLong, paramBoolean, paramt);
      AppMethodBeat.o(204118);
      return;
    }
    AppMethodBeat.o(204118);
  }
  
  public final void cEF()
  {
    AppMethodBeat.i(204120);
    FinderCommentDrawer localFinderCommentDrawer = this.roO;
    if (localFinderCommentDrawer != null)
    {
      localFinderCommentDrawer.cEF();
      AppMethodBeat.o(204120);
      return;
    }
    AppMethodBeat.o(204120);
  }
  
  public final boolean cEG()
  {
    AppMethodBeat.i(204121);
    FinderCommentDrawer localFinderCommentDrawer = this.roO;
    if (localFinderCommentDrawer != null)
    {
      boolean bool = localFinderCommentDrawer.cEG();
      AppMethodBeat.o(204121);
      return bool;
    }
    AppMethodBeat.o(204121);
    return false;
  }
  
  public final void d(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(204123);
    Object localObject = b.rCU;
    if ((b.czM()) && (paramInt == 500) && (paramIntent != null))
    {
      paramIntent = a.ah(paramIntent);
      if (paramIntent != null)
      {
        localObject = this.rgz;
        if (localObject != null)
        {
          ((CommentDrawerContract.CloseDrawerCallback)localObject).g(paramIntent.commentCount, paramIntent.oAg);
          AppMethodBeat.o(204123);
          return;
        }
        AppMethodBeat.o(204123);
        return;
      }
    }
    AppMethodBeat.o(204123);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(210212);
    FinderCommentDrawer localFinderCommentDrawer = this.roO;
    if (localFinderCommentDrawer != null)
    {
      localFinderCommentDrawer.cMT();
      AppMethodBeat.o(210212);
      return;
    }
    AppMethodBeat.o(210212);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(204122);
    FinderCommentDrawer localFinderCommentDrawer = this.roO;
    if (localFinderCommentDrawer != null)
    {
      localFinderCommentDrawer.cEJ();
      AppMethodBeat.o(204122);
      return;
    }
    AppMethodBeat.o(204122);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion;", "", "()V", "COMMENT_REQUEST_KEY", "", "COMMENT_RESULT_KEY", "FROM_MSG", "MENTION_CREATE_TIME", "MENTION_ID", "REQ_CODE", "", "TAG", "drawerRequestMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerCreateData;", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerOpenData;", "drawerResultMap", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerResultData;", "createDrawerForMsg", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "mentionId", "mentionCreateTime", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "commentScene", "safeMode", "", "createDrawerToAttachWindow", "parent", "Landroid/view/View;", "fromMsg", "intent", "Landroid/content/Intent;", "getDrawerRequestData", "getDrawerResultData", "getMentionCreateTime", "getMentionId", "putDrawerResultData", "", "resultData", "DrawerCreateData", "DrawerOpenData", "DrawerResultData", "plugin-finder_release"})
  public static final class a
  {
    public static d a(MMActivity paramMMActivity, View paramView, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(204116);
      k.h(paramMMActivity, "context");
      k.h(paramView, "parent");
      paramMMActivity.getWindow().setSoftInputMode(50);
      d locald = new d(paramInt, paramBoolean, (byte)0);
      d.a(locald, paramMMActivity);
      Object localObject = b.rCU;
      if (b.czM()) {
        d.a(locald, null);
      }
      for (;;)
      {
        AppMethodBeat.o(204116);
        return locald;
        localObject = FinderCommentDrawer.rVZ;
        d.a(locald, FinderCommentDrawer.b.b(paramMMActivity, paramView, paramInt, paramBoolean));
      }
    }
    
    public static d.a.c ah(Intent paramIntent)
    {
      AppMethodBeat.i(204117);
      k.h(paramIntent, "intent");
      long l = paramIntent.getLongExtra("COMMENT_RESULT_KEY", 0L);
      paramIntent = (d.a.c)d.cEI().remove(Long.valueOf(l));
      AppMethodBeat.o(204117);
      return paramIntent;
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerOpenData;", "", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isSingleMode", "", "refCommentId", "", "blinkRefComment", "showFooter", "replyCommentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;ZJZZLcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;)V", "getBlinkRefComment", "()Z", "getFeedObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getRefCommentId", "()J", "getReplyCommentObj", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "getShowFooter", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
    public static final class b
    {
      public final long qXy;
      public final boolean rVS;
      public final t rVT;
      public final boolean rgD;
      public final boolean rgE;
      public final FinderItem rgw;
      
      public b(FinderItem paramFinderItem, long paramLong, boolean paramBoolean, t paramt)
      {
        AppMethodBeat.i(204108);
        this.rgw = paramFinderItem;
        this.rgD = false;
        this.qXy = paramLong;
        this.rgE = paramBoolean;
        this.rVS = true;
        this.rVT = paramt;
        AppMethodBeat.o(204108);
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(204111);
        if (this != paramObject)
        {
          if ((paramObject instanceof b))
          {
            paramObject = (b)paramObject;
            if ((!k.g(this.rgw, paramObject.rgw)) || (this.rgD != paramObject.rgD) || (this.qXy != paramObject.qXy) || (this.rgE != paramObject.rgE) || (this.rVS != paramObject.rVS) || (!k.g(this.rVT, paramObject.rVT))) {}
          }
        }
        else
        {
          AppMethodBeat.o(204111);
          return true;
        }
        AppMethodBeat.o(204111);
        return false;
      }
      
      public final int hashCode()
      {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
      }
      
      public final String toString()
      {
        AppMethodBeat.i(204109);
        String str = "DrawerOpenData(feedObj=" + this.rgw + ", isSingleMode=" + this.rgD + ", refCommentId=" + this.qXy + ", blinkRefComment=" + this.rgE + ", showFooter=" + this.rVS + ", replyCommentObj=" + this.rVT + ")";
        AppMethodBeat.o(204109);
        return str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.d
 * JD-Core Version:    0.7.0.1
 */