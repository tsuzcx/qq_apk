package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.luggage.k.f.c;
import com.tencent.luggage.sdk.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.de;
import com.tencent.mm.plugin.messenger.a.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.aa.d;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareVideoToConversationLogic;", "", "()V", "SHARE_VIDEO_REQUEST_CODE", "", "buildSelectConversationIntent", "Landroid/content/Intent;", "videoPath", "", "doShare", "", "activity", "Landroid/app/Activity;", "thumbPath", "shareCallBack", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareResult;", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareCallBack;", "doShareVideoAfterSelectConversation", "durationS", "selectedUsers", "", "customSendText", "onVideoSent", "Ljava/lang/Runnable;", "isVideoLegal2Share", "isVideoLegalCallback", "Lkotlin/Function2;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareVideoToConversationLogic$VideoInfo;", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/IsFileLegalCallback;", "VideoInfo", "plugin-appbrand-integration_release"})
final class ad
{
  private static final int pri;
  public static final ad prj;
  
  static
  {
    AppMethodBeat.i(281017);
    ad localad = new ad();
    prj = localad;
    pri = a.aI(localad);
    AppMethodBeat.o(281017);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareVideoToConversationLogic$VideoInfo;", "", "durationS", "", "(I)V", "getDurationS", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-appbrand-integration_release"})
  static final class a
  {
    final int prk;
    
    public a(int paramInt)
    {
      this.prk = paramInt;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if (this.prk != paramObject.prk) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      return this.prk;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(270285);
      String str = "VideoInfo(durationS=" + this.prk + ")";
      AppMethodBeat.o(270285);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "isVideoLegal", "", "videoInfo", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareVideoToConversationLogic$VideoInfo;", "invoke"})
  static final class b
    extends q
    implements m<Boolean, ad.a, x>
  {
    b(b paramb, Activity paramActivity, String paramString1, String paramString2)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onSent"})
  static final class c
    implements d.a
  {
    c(String paramString, aa.d paramd, Runnable paramRunnable) {}
    
    public final void bUv()
    {
      AppMethodBeat.i(274660);
      Log.d("MicroMsg.AppBrand.JsApiShareVideoMessage", "doShareVideoAfterSelectConversation, send video to " + this.prq + " done");
      aa.d locald = this.prr;
      locald.aaBA -= 1;
      if (this.prr.aaBA <= 0)
      {
        Log.i("MicroMsg.AppBrand.JsApiShareVideoMessage", "doShareVideoAfterSelectConversation, send video done");
        this.prs.run();
      }
      AppMethodBeat.o(274660);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class d
    implements DialogInterface.OnClickListener
  {
    d(m paramm) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(267293);
      this.prt.invoke(Boolean.FALSE, null);
      AppMethodBeat.o(267293);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
  static final class e
    implements DialogInterface.OnClickListener
  {
    e(m paramm) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(269949);
      this.prt.invoke(Boolean.FALSE, null);
      AppMethodBeat.o(269949);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.ad
 * JD-Core Version:    0.7.0.1
 */