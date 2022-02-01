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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "", "()V", "scene", "", "safeMode", "", "onCloseDrawerCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "(IZLcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;)V", "context", "Lcom/tencent/mm/ui/MMActivity;", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "drawerCreateData", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerCreateData;", "drawerOpenData", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerOpenData;", "fromMsg", "mentionCreateTime", "mentionId", "", "closeDrawer", "", "getDrawer", "isDrawerOpen", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onDetach", "onUIPause", "onUIResume", "openDrawer", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isSingleMode", "refCommentId", "blinkRefComment", "showFooter", "replyCommentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "banSwitch", "reason", "Companion", "plugin-finder_release"})
public final class e
{
  private static final ConcurrentHashMap<Long, o<e.a.a, e.a.b>> tdK;
  private static final ConcurrentHashMap<Long, e.a.c> tdL;
  public static final a tdM;
  private MMActivity fNT;
  private CommentDrawerContract.CloseDrawerCallback sdk;
  public FinderCommentDrawer sdu;
  private boolean smq;
  private long smr;
  private int sms;
  private final e.a.a tdI;
  private e.a.b tdJ;
  
  static
  {
    AppMethodBeat.i(205714);
    tdM = new a((byte)0);
    tdK = new ConcurrentHashMap();
    tdL = new ConcurrentHashMap();
    AppMethodBeat.o(205714);
  }
  
  public e()
  {
    this.tdI = null;
  }
  
  private e(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(205713);
    this.tdI = new e.a.a(paramInt, paramBoolean);
    AppMethodBeat.o(205713);
  }
  
  public final void a(FinderItem paramFinderItem, boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3, ab paramab, boolean paramBoolean4, int paramInt, CommentDrawerContract.CloseDrawerCallback paramCloseDrawerCallback)
  {
    AppMethodBeat.i(205706);
    d.g.b.p.h(paramFinderItem, "feedObj");
    this.sdk = paramCloseDrawerCallback;
    Object localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
    if (((Number)com.tencent.mm.plugin.finder.storage.b.cIL().value()).intValue() == 1)
    {
      paramCloseDrawerCallback = com.tencent.mm.plugin.finder.utils.p.sXz;
      localObject = this.tdI;
      paramCloseDrawerCallback = this.fNT;
      if ((localObject != null) && (paramCloseDrawerCallback != null))
      {
        this.tdJ = new e.a.b(paramFinderItem, paramBoolean1, paramLong, paramBoolean2, paramBoolean3, paramab);
        paramLong = System.currentTimeMillis();
        paramFinderItem = (Map)tdK;
        paramab = this.tdJ;
        if (paramab == null) {
          d.g.b.p.bdF("drawerOpenData");
        }
        paramFinderItem.put(Long.valueOf(paramLong), new o(localObject, paramab));
        paramFinderItem = new Intent();
        paramFinderItem.putExtra("COMMENT_REQUEST_KEY", paramLong);
        paramFinderItem.putExtra("FROM_MSG", this.smq);
        paramFinderItem.putExtra("MENTION_ID", this.smr);
        paramFinderItem.putExtra("MENTION_CREATE_TIME", this.sms);
        paramab = FinderReporterUIC.tnG;
        FinderReporterUIC.a.a((Context)paramCloseDrawerCallback, paramFinderItem, 0L, 0, false, 124);
        paramab = a.sVQ;
        a.c(paramCloseDrawerCallback, paramFinderItem);
        AppMethodBeat.o(205706);
      }
    }
    else
    {
      localObject = this.sdu;
      if (localObject != null) {
        ((FinderCommentDrawer)localObject).setOnCloseDrawerCallback(paramCloseDrawerCallback);
      }
      paramCloseDrawerCallback = this.sdu;
      if (paramCloseDrawerCallback != null)
      {
        FinderCommentDrawer.a(paramCloseDrawerCallback, paramFinderItem, paramBoolean1, paramLong, paramBoolean2, paramBoolean3, paramab, paramBoolean4, paramInt, 64);
        AppMethodBeat.o(205706);
        return;
      }
    }
    AppMethodBeat.o(205706);
  }
  
  public final void cPH()
  {
    AppMethodBeat.i(205708);
    FinderCommentDrawer localFinderCommentDrawer = this.sdu;
    if (localFinderCommentDrawer != null)
    {
      localFinderCommentDrawer.cPH();
      AppMethodBeat.o(205708);
      return;
    }
    AppMethodBeat.o(205708);
  }
  
  public final boolean cPI()
  {
    AppMethodBeat.i(205709);
    FinderCommentDrawer localFinderCommentDrawer = this.sdu;
    if (localFinderCommentDrawer != null)
    {
      boolean bool = localFinderCommentDrawer.cPI();
      AppMethodBeat.o(205709);
      return bool;
    }
    AppMethodBeat.o(205709);
    return false;
  }
  
  public final void d(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(205712);
    Object localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
    if ((((Number)com.tencent.mm.plugin.finder.storage.b.cIL().value()).intValue() == 1) && (paramInt == 500) && (paramIntent != null))
    {
      paramIntent = a.an(paramIntent);
      if (paramIntent != null)
      {
        localObject = this.sdk;
        if (localObject != null)
        {
          ((CommentDrawerContract.CloseDrawerCallback)localObject).g(paramIntent.commentCount, paramIntent.pkh);
          AppMethodBeat.o(205712);
          return;
        }
        AppMethodBeat.o(205712);
        return;
      }
    }
    AppMethodBeat.o(205712);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(205711);
    FinderCommentDrawer localFinderCommentDrawer = this.sdu;
    if (localFinderCommentDrawer != null)
    {
      localFinderCommentDrawer.cQu();
      AppMethodBeat.o(205711);
      return;
    }
    AppMethodBeat.o(205711);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(205710);
    FinderCommentDrawer localFinderCommentDrawer = this.sdu;
    if (localFinderCommentDrawer != null)
    {
      localFinderCommentDrawer.cPL();
      AppMethodBeat.o(205710);
      return;
    }
    AppMethodBeat.o(205710);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion;", "", "()V", "COMMENT_REQUEST_KEY", "", "COMMENT_RESULT_KEY", "FROM_MSG", "MENTION_CREATE_TIME", "MENTION_ID", "REQ_CODE", "", "TAG", "drawerRequestMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerCreateData;", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerOpenData;", "drawerResultMap", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerResultData;", "createDrawerForMsg", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "mentionId", "mentionCreateTime", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "commentScene", "safeMode", "", "createDrawerToAttachWindow", "parent", "Landroid/view/View;", "fromMsg", "intent", "Landroid/content/Intent;", "getDrawerRequestData", "getDrawerResultData", "getMentionCreateTime", "getMentionId", "putDrawerResultData", "", "resultData", "DrawerCreateData", "DrawerOpenData", "DrawerResultData", "plugin-finder_release"})
  public static final class a
  {
    public static e a(MMActivity paramMMActivity, View paramView, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(205704);
      d.g.b.p.h(paramMMActivity, "context");
      d.g.b.p.h(paramView, "parent");
      paramMMActivity.getWindow().setSoftInputMode(50);
      e locale = new e(paramInt, paramBoolean, (byte)0);
      e.a(locale, paramMMActivity);
      Object localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cIL().value()).intValue() == 1) {
        e.a(locale, null);
      }
      for (;;)
      {
        AppMethodBeat.o(205704);
        return locale;
        localObject = FinderCommentDrawer.tdV;
        e.a(locale, FinderCommentDrawer.b.b(paramMMActivity, paramView, paramInt, paramBoolean));
      }
    }
    
    public static e.a.c an(Intent paramIntent)
    {
      AppMethodBeat.i(205705);
      d.g.b.p.h(paramIntent, "intent");
      long l = paramIntent.getLongExtra("COMMENT_RESULT_KEY", 0L);
      paramIntent = (e.a.c)e.cPK().remove(Long.valueOf(l));
      AppMethodBeat.o(205705);
      return paramIntent;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerOpenData;", "", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isSingleMode", "", "refCommentId", "", "blinkRefComment", "showFooter", "replyCommentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;ZJZZLcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;)V", "getBlinkRefComment", "()Z", "getFeedObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getRefCommentId", "()J", "getReplyCommentObj", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "getShowFooter", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
    public static final class b
    {
      public final long rQR;
      public final FinderItem scK;
      public final boolean sdo;
      public final boolean sdp;
      public final boolean tdN;
      public final ab tdO;
      
      public b(FinderItem paramFinderItem, boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3, ab paramab)
      {
        AppMethodBeat.i(205696);
        this.scK = paramFinderItem;
        this.sdo = paramBoolean1;
        this.rQR = paramLong;
        this.sdp = paramBoolean2;
        this.tdN = paramBoolean3;
        this.tdO = paramab;
        AppMethodBeat.o(205696);
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(205699);
        if (this != paramObject)
        {
          if ((paramObject instanceof b))
          {
            paramObject = (b)paramObject;
            if ((!d.g.b.p.i(this.scK, paramObject.scK)) || (this.sdo != paramObject.sdo) || (this.rQR != paramObject.rQR) || (this.sdp != paramObject.sdp) || (this.tdN != paramObject.tdN) || (!d.g.b.p.i(this.tdO, paramObject.tdO))) {}
          }
        }
        else
        {
          AppMethodBeat.o(205699);
          return true;
        }
        AppMethodBeat.o(205699);
        return false;
      }
      
      public final int hashCode()
      {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
      }
      
      public final String toString()
      {
        AppMethodBeat.i(205697);
        String str = "DrawerOpenData(feedObj=" + this.scK + ", isSingleMode=" + this.sdo + ", refCommentId=" + this.rQR + ", blinkRefComment=" + this.sdp + ", showFooter=" + this.tdN + ", replyCommentObj=" + this.tdO + ")";
        AppMethodBeat.o(205697);
        return str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.e
 * JD-Core Version:    0.7.0.1
 */