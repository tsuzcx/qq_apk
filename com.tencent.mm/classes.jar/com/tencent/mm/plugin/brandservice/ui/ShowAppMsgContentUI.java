package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.cp.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.d.h;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.u;
import kotlin.j;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/ShowAppMsgContentUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "MENU_ID_COPY", "", "getMENU_ID_COPY", "()I", "TAG", "", "contentTV", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getContentTV", "()Landroid/widget/TextView;", "contentTV$delegate", "Lkotlin/Lazy;", "msgId", "", "getMsgId", "()J", "msgId$delegate", "msgInfo", "Lcom/tencent/mm/storage/MsgInfo;", "tipDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getLayoutId", "getMoreInfo", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ShowAppMsgContentUI
  extends MMActivity
{
  private final String TAG;
  private cc hTm;
  private w tipDialog;
  private final int vEM;
  private final j vEN;
  private final j vEO;
  
  public ShowAppMsgContentUI()
  {
    AppMethodBeat.i(6526);
    this.TAG = "MicroMsg.ShowAppMsgContentUI";
    this.vEM = 1;
    this.vEN = kotlin.k.cm((a)new a(this));
    this.vEO = kotlin.k.cm((a)new b(this));
    AppMethodBeat.o(6526);
  }
  
  private static final CharSequence a(ShowAppMsgContentUI paramShowAppMsgContentUI, Void paramVoid)
  {
    Object localObject1 = null;
    AppMethodBeat.i(301574);
    kotlin.g.b.s.u(paramShowAppMsgContentUI, "this$0");
    for (;;)
    {
      try
      {
        Context localContext = (Context)paramShowAppMsgContentUI;
        StringBuilder localStringBuilder = new StringBuilder();
        JSONObject localJSONObject = new JSONObject();
        Object localObject2 = paramShowAppMsgContentUI.hTm;
        paramVoid = (Void)localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("msgInfo");
          paramVoid = null;
        }
        localJSONObject.put("msgId", paramVoid.field_msgId);
        localObject2 = paramShowAppMsgContentUI.hTm;
        paramVoid = (Void)localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("msgInfo");
          paramVoid = null;
        }
        localJSONObject.put("msgSvrId", paramVoid.field_msgSvrId);
        localObject2 = paramShowAppMsgContentUI.hTm;
        paramVoid = (Void)localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("msgInfo");
          paramVoid = null;
        }
        localJSONObject.put("talker", paramVoid.field_talker);
        localObject2 = paramShowAppMsgContentUI.hTm;
        paramVoid = (Void)localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("msgInfo");
          paramVoid = null;
        }
        localJSONObject.put("isSend", paramVoid.field_isSend);
        localObject2 = paramShowAppMsgContentUI.hTm;
        paramVoid = (Void)localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("msgInfo");
          paramVoid = null;
        }
        localJSONObject.put("status", paramVoid.field_status);
        localObject2 = paramShowAppMsgContentUI.hTm;
        paramVoid = (Void)localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("msgInfo");
          paramVoid = null;
        }
        localJSONObject.put("type", paramVoid.getType());
        localObject2 = paramShowAppMsgContentUI.hTm;
        paramVoid = (Void)localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("msgInfo");
          paramVoid = null;
        }
        localJSONObject.put("createTime", paramVoid.getCreateTime());
        localObject2 = paramShowAppMsgContentUI.hTm;
        paramVoid = (Void)localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("msgInfo");
          paramVoid = null;
        }
        if (!Util.isNullOrNil(paramVoid.field_bizClientMsgId))
        {
          localObject2 = paramShowAppMsgContentUI.hTm;
          paramVoid = (Void)localObject2;
          if (localObject2 == null)
          {
            kotlin.g.b.s.bIx("msgInfo");
            paramVoid = null;
          }
          localJSONObject.put("bizClientMsgId", paramVoid.field_bizClientMsgId);
        }
        localObject2 = paramShowAppMsgContentUI.hTm;
        paramVoid = (Void)localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("msgInfo");
          paramVoid = null;
        }
        if (!Util.isNullOrNil(paramVoid.jUr))
        {
          localObject2 = paramShowAppMsgContentUI.hTm;
          paramVoid = (Void)localObject2;
          if (localObject2 == null)
          {
            kotlin.g.b.s.bIx("msgInfo");
            paramVoid = null;
          }
          localJSONObject.put("msgSource", paramVoid.jUr);
        }
        paramVoid = localJSONObject.toString();
        kotlin.g.b.s.s(paramVoid, "json.toString()");
        localObject2 = localStringBuilder.append(paramVoid).append('\n');
        paramVoid = paramShowAppMsgContentUI.hTm;
        if (paramVoid != null) {
          continue;
        }
        kotlin.g.b.s.bIx("msgInfo");
        paramVoid = localObject1;
        paramVoid = (CharSequence)p.a(localContext, (CharSequence)paramVoid.field_content, (int)paramShowAppMsgContentUI.dcE().getTextSize(), null, null);
        paramShowAppMsgContentUI = paramVoid;
      }
      catch (Exception paramVoid)
      {
        Log.e(paramShowAppMsgContentUI.TAG, kotlin.g.b.s.X("spanForTextViewWithExtra ex: ", paramVoid.getMessage()));
        paramShowAppMsgContentUI = (CharSequence)"";
        continue;
      }
      AppMethodBeat.o(301574);
      return paramShowAppMsgContentUI;
    }
  }
  
  private static final ah a(ShowAppMsgContentUI paramShowAppMsgContentUI, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(301576);
    kotlin.g.b.s.u(paramShowAppMsgContentUI, "this$0");
    TextView localTextView = paramShowAppMsgContentUI.dcE();
    if (localTextView != null) {
      localTextView.setText(paramCharSequence);
    }
    paramShowAppMsgContentUI = paramShowAppMsgContentUI.tipDialog;
    if (paramShowAppMsgContentUI == null)
    {
      AppMethodBeat.o(301576);
      return null;
    }
    paramShowAppMsgContentUI.dismiss();
    paramShowAppMsgContentUI = ah.aiuX;
    AppMethodBeat.o(301576);
    return paramShowAppMsgContentUI;
  }
  
  private static final void a(ShowAppMsgContentUI paramShowAppMsgContentUI, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(301582);
    kotlin.g.b.s.u(paramShowAppMsgContentUI, "this$0");
    if (paramMenuItem.getItemId() == paramShowAppMsgContentUI.vEM)
    {
      Context localContext = MMApplicationContext.getContext();
      cc localcc = paramShowAppMsgContentUI.hTm;
      paramMenuItem = localcc;
      if (localcc == null)
      {
        kotlin.g.b.s.bIx("msgInfo");
        paramMenuItem = null;
      }
      ClipboardHelper.setText(localContext, null, (CharSequence)paramMenuItem.field_content);
      com.tencent.mm.ui.base.k.cZ((Context)paramShowAppMsgContentUI.getContext(), paramShowAppMsgContentUI.getContext().getString(d.i.app_copy_ok));
      AppMethodBeat.o(301582);
      return;
    }
    Log.w(paramShowAppMsgContentUI.TAG, "default onMMMenuItemSelected err");
    AppMethodBeat.o(301582);
  }
  
  private static final void a(ShowAppMsgContentUI paramShowAppMsgContentUI, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(301581);
    kotlin.g.b.s.u(paramShowAppMsgContentUI, "this$0");
    params.oh(paramShowAppMsgContentUI.vEM, d.i.app_copy);
    AppMethodBeat.o(301581);
  }
  
  private static final boolean a(ShowAppMsgContentUI paramShowAppMsgContentUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(301579);
    kotlin.g.b.s.u(paramShowAppMsgContentUI, "this$0");
    paramShowAppMsgContentUI.hideVKB();
    paramShowAppMsgContentUI.finish();
    AppMethodBeat.o(301579);
    return true;
  }
  
  private final long aJG()
  {
    AppMethodBeat.i(6523);
    long l = ((Number)this.vEO.getValue()).longValue();
    AppMethodBeat.o(6523);
    return l;
  }
  
  private static final boolean b(ShowAppMsgContentUI paramShowAppMsgContentUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(301583);
    kotlin.g.b.s.u(paramShowAppMsgContentUI, "this$0");
    paramMenuItem = new com.tencent.mm.ui.widget.a.f((Context)paramShowAppMsgContentUI, 1, false);
    paramMenuItem.Vtg = new ShowAppMsgContentUI..ExternalSyntheticLambda2(paramShowAppMsgContentUI);
    paramMenuItem.GAC = new ShowAppMsgContentUI..ExternalSyntheticLambda3(paramShowAppMsgContentUI);
    paramMenuItem.dDn();
    AppMethodBeat.o(301583);
    return true;
  }
  
  private final TextView dcE()
  {
    AppMethodBeat.i(301568);
    TextView localTextView = (TextView)this.vEN.getValue();
    AppMethodBeat.o(301568);
    return localTextView;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return d.f.show_app_msg_content_activity;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(6524);
    super.onCreate(paramBundle);
    paramBundle = ((n)h.ax(n.class)).gaZ().sl(aJG());
    kotlin.g.b.s.s(paramBundle, "service(IMessengerStorag…msgInfoStg.getById(msgId)");
    this.hTm = paramBundle;
    if (this.hTm == null) {
      kotlin.g.b.s.bIx("msgInfo");
    }
    cc localcc = this.hTm;
    paramBundle = localcc;
    if (localcc == null)
    {
      kotlin.g.b.s.bIx("msgInfo");
      paramBundle = null;
    }
    if (paramBundle.field_msgId <= 0L)
    {
      Log.w(this.TAG, "onCreate msg is invalid %d", new Object[] { Long.valueOf(aJG()) });
      finish();
      AppMethodBeat.o(6524);
      return;
    }
    paramBundle = (Context)getContext();
    getContext().getString(d.i.app_tip);
    this.tipDialog = com.tencent.mm.ui.base.k.a(paramBundle, getContext().getString(d.i.app_waiting), true, null);
    g.jPX().j(new ShowAppMsgContentUI..ExternalSyntheticLambda5(this)).b(new ShowAppMsgContentUI..ExternalSyntheticLambda4(this));
    setBackBtn(new ShowAppMsgContentUI..ExternalSyntheticLambda0(this));
    setMMTitle(d.i.menu_show_app_msg_content);
    addIconOptionMenu(0, getString(d.i.app_more), d.h.actionbar_icon_dark_more, new ShowAppMsgContentUI..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(6524);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(6525);
    super.onDestroy();
    w localw = this.tipDialog;
    if ((localw != null) && (localw.isShowing())) {
      localw.dismiss();
    }
    AppMethodBeat.o(6525);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<TextView>
  {
    a(ShowAppMsgContentUI paramShowAppMsgContentUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<Long>
  {
    b(ShowAppMsgContentUI paramShowAppMsgContentUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.ShowAppMsgContentUI
 * JD-Core Version:    0.7.0.1
 */