package com.tencent.mm.plugin.finder.uniComments;

import android.content.Context;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMFragmentActivity;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/UniCommentComponent;", "", "()V", "scene", "", "safeMode", "", "onCloseDrawerCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "(IZLcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;)V", "context", "Lcom/tencent/mm/ui/MMFragmentActivity;", "drawer", "Lcom/tencent/mm/plugin/finder/uniComments/UniCommentDrawer;", "drawerCreateData", "Lcom/tencent/mm/plugin/finder/uniComments/UniCommentComponent$Companion$DrawerCreateData;", "drawerOpenData", "Lcom/tencent/mm/plugin/finder/uniComments/UniCommentComponent$Companion$DrawerOpenData;", "fromMsg", "mentionCreateTime", "mentionId", "", "Lcom/tencent/mm/plugin/finder/uniComments/UniCommentDrawerContract$CloseDrawerCallback;", "closeDrawer", "", "getDrawer", "isDrawerOpen", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onDetach", "onUIPause", "onUIResume", "openDrawer", "feedObj", "Lcom/tencent/mm/plugin/finder/uniComments/model/UniEntityItem;", "isSingleMode", "refCommentId", "blinkRefComment", "showFooter", "replyCommentObj", "Lcom/tencent/mm/plugin/finder/uniComments/storge/LocalUniCommentObject;", "banSwitch", "reason", "isOnlyShowDesc", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  private static final ConcurrentHashMap<Long, r<d.a.a, d.a.b>> FYF;
  private static final ConcurrentHashMap<Long, Object> FYG;
  public static final a FYz;
  private long ABR;
  private boolean BlY;
  private int BlZ;
  public UniCommentDrawer FYA;
  private MMFragmentActivity FYB;
  private final d.a.a FYC;
  private d.a.b FYD;
  private e.a FYE;
  
  static
  {
    AppMethodBeat.i(341461);
    FYz = new a((byte)0);
    FYF = new ConcurrentHashMap();
    FYG = new ConcurrentHashMap();
    AppMethodBeat.o(341461);
  }
  
  public d()
  {
    this.FYC = null;
  }
  
  private d(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(341430);
    this.FYC = new d.a.a(2, false);
    AppMethodBeat.o(341430);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/UniCommentComponent$Companion;", "", "()V", "COMMENT_REQUEST_KEY", "", "COMMENT_RESULT_KEY", "FROM_MSG", "MENTION_CREATE_TIME", "MENTION_ID", "REQ_CODE", "", "TAG", "drawerRequestMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/uniComments/UniCommentComponent$Companion$DrawerCreateData;", "Lcom/tencent/mm/plugin/finder/uniComments/UniCommentComponent$Companion$DrawerOpenData;", "drawerResultMap", "Lcom/tencent/mm/plugin/finder/uniComments/UniCommentComponent$Companion$DrawerResultData;", "createDrawerForMsg", "Lcom/tencent/mm/plugin/finder/uniComments/UniCommentComponent;", "mentionId", "mentionCreateTime", "context", "Lcom/tencent/mm/ui/MMFragmentActivity;", "scene", "commentScene", "safeMode", "", "createDrawerToAttachWindow", "parent", "Landroid/view/View;", "exposeScene", "fromMsg", "intent", "Landroid/content/Intent;", "getDrawerRequestData", "getDrawerResultData", "getMentionCreateTime", "getMentionId", "putDrawerResultData", "", "resultData", "DrawerCreateData", "DrawerOpenData", "DrawerResultData", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static d a(MMFragmentActivity paramMMFragmentActivity, View paramView)
    {
      AppMethodBeat.i(341577);
      s.u(paramMMFragmentActivity, "context");
      s.u(paramView, "parent");
      paramMMFragmentActivity.getWindow().setSoftInputMode(50);
      d locald = new d((byte)0);
      d.a(locald, paramMMFragmentActivity);
      Object localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eRX().bmg()).intValue() == 1) {
        d.a(locald, null);
      }
      for (;;)
      {
        AppMethodBeat.o(341577);
        return locald;
        localObject = UniCommentDrawer.FYK;
        d.a(locald, UniCommentDrawer.b.a(paramMMFragmentActivity, paramView, (UniCommentDrawer.a)new i((e.b)new f((Context)paramMMFragmentActivity))));
      }
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/UniCommentComponent$Companion$DrawerOpenData;", "", "feedObj", "Lcom/tencent/mm/plugin/finder/uniComments/model/UniEntityItem;", "isSingleMode", "", "refCommentId", "", "blinkRefComment", "showFooter", "replyCommentObj", "Lcom/tencent/mm/plugin/finder/uniComments/storge/LocalUniCommentObject;", "(Lcom/tencent/mm/plugin/finder/uniComments/model/UniEntityItem;ZJZZLcom/tencent/mm/plugin/finder/uniComments/storge/LocalUniCommentObject;)V", "getBlinkRefComment", "()Z", "getFeedObj", "()Lcom/tencent/mm/plugin/finder/uniComments/model/UniEntityItem;", "getRefCommentId", "()J", "getReplyCommentObj", "()Lcom/tencent/mm/plugin/finder/uniComments/storge/LocalUniCommentObject;", "getShowFooter", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
    {
      private final long AAW;
      private final boolean AUq;
      private final com.tencent.mm.plugin.finder.uniComments.model.b FYH;
      private final boolean FYI;
      private final com.tencent.mm.plugin.finder.uniComments.storge.b FYJ;
      private final boolean plm;
      
      public b(com.tencent.mm.plugin.finder.uniComments.model.b paramb, long paramLong)
      {
        AppMethodBeat.i(341585);
        this.FYH = paramb;
        this.plm = false;
        this.AAW = paramLong;
        this.AUq = true;
        this.FYI = true;
        this.FYJ = null;
        AppMethodBeat.o(341585);
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(341607);
        if (this == paramObject)
        {
          AppMethodBeat.o(341607);
          return true;
        }
        if (!(paramObject instanceof b))
        {
          AppMethodBeat.o(341607);
          return false;
        }
        paramObject = (b)paramObject;
        if (!s.p(this.FYH, paramObject.FYH))
        {
          AppMethodBeat.o(341607);
          return false;
        }
        if (this.plm != paramObject.plm)
        {
          AppMethodBeat.o(341607);
          return false;
        }
        if (this.AAW != paramObject.AAW)
        {
          AppMethodBeat.o(341607);
          return false;
        }
        if (this.AUq != paramObject.AUq)
        {
          AppMethodBeat.o(341607);
          return false;
        }
        if (this.FYI != paramObject.FYI)
        {
          AppMethodBeat.o(341607);
          return false;
        }
        if (!s.p(this.FYJ, paramObject.FYJ))
        {
          AppMethodBeat.o(341607);
          return false;
        }
        AppMethodBeat.o(341607);
        return true;
      }
      
      public final int hashCode()
      {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
      }
      
      public final String toString()
      {
        AppMethodBeat.i(341594);
        String str = "DrawerOpenData(feedObj=" + this.FYH + ", isSingleMode=" + this.plm + ", refCommentId=" + this.AAW + ", blinkRefComment=" + this.AUq + ", showFooter=" + this.FYI + ", replyCommentObj=" + this.FYJ + ')';
        AppMethodBeat.o(341594);
        return str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.uniComments.d
 * JD-Core Version:    0.7.0.1
 */