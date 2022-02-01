package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.finder.cgi.di;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.e.k;
import com.tencent.mm.plugin.finder.widget.pref.a;
import com.tencent.mm.protocal.protobuf.ax;
import com.tencent.mm.protocal.protobuf.az;
import com.tencent.mm.protocal.protobuf.bys;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderAccountManagent;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "accountExtConfig", "Lcom/tencent/mm/protocal/protobuf/AccountExtraSettingConfig;", "isFirstResume", "", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "getResourceId", "", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPreferenceTreeClick", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refresh", "updateView", "isRemoveAll", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderAccountManagent
  extends MMPreference
  implements com.tencent.mm.am.h
{
  public static final a BkX;
  private static final String BkZ;
  private boolean AuP = true;
  private bys AwM;
  private ax BkY;
  private final String TAG = "Finder.FinderAccountManagent";
  
  static
  {
    AppMethodBeat.i(364901);
    BkX = new a((byte)0);
    BkZ = "ACCOUNT_EXTRA_CONFIG";
    AppMethodBeat.o(364901);
  }
  
  private static final boolean a(FinderAccountManagent paramFinderAccountManagent, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(364892);
    kotlin.g.b.s.u(paramFinderAccountManagent, "this$0");
    paramFinderAccountManagent.finish();
    AppMethodBeat.o(364892);
    return true;
  }
  
  private final void kD(boolean paramBoolean)
  {
    AppMethodBeat.i(364887);
    if (paramBoolean) {
      getPreferenceScreen().removeAll();
    }
    Object localObject = this.BkY;
    if (localObject != null)
    {
      localObject = ((ax)localObject).YBN;
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          az localaz = (az)((Iterator)localObject).next();
          f localf = getPreferenceScreen();
          kotlin.g.b.s.s(localaz, "it");
          localf.c((Preference)new a(localaz, (Context)this));
        }
      }
    }
    getPreferenceScreen().notifyDataSetChanged();
    AppMethodBeat.o(364887);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getResourceId()
  {
    return e.k.finder_account_managent_pref;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(364922);
    super.initView();
    kD(false);
    AppMethodBeat.o(364922);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(364914);
    super.onCreate(paramBundle);
    setMMTitle(e.h.finder_account_management);
    setBackBtn(new FinderAccountManagent..ExternalSyntheticLambda0(this));
    byte[] arrayOfByte = getIntent().getByteArrayExtra(BkZ);
    if (arrayOfByte == null) {
      paramBundle = null;
    }
    for (;;)
    {
      this.BkY = paramBundle;
      if (this.BkY != null) {
        break;
      }
      finish();
      AppMethodBeat.o(364914);
      return;
      paramBundle = new ax();
      paramBundle.parseFrom(arrayOfByte);
    }
    initView();
    com.tencent.mm.kernel.h.aZW().a(3761, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(364914);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(364943);
    super.onDestroy();
    com.tencent.mm.kernel.h.aZW().b(3761, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(364943);
  }
  
  public final boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    g localg = null;
    AppMethodBeat.i(364956);
    if (paramPreference == null)
    {
      paramf = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.widget.pref.FinderAccountManagementPref");
      AppMethodBeat.o(364956);
      throw paramf;
    }
    a locala = (a)paramPreference;
    paramf = locala.HaX;
    if (paramf == null)
    {
      paramf = null;
      if (paramf != null) {
        break label73;
      }
      label51:
      if (paramf != null) {
        break label137;
      }
    }
    label73:
    while (paramf.intValue() != 1)
    {
      AppMethodBeat.o(364956);
      return true;
      paramf = Integer.valueOf(paramf.wuj);
      break;
      if (paramf.intValue() != 2) {
        break label51;
      }
      paramPreference = new Intent();
      paramf = locala.HaX;
      if (paramf == null) {}
      for (paramf = localg;; paramf = paramf.xmo)
      {
        paramPreference.putExtra("rawUrl", paramf);
        c.b(locala.mContext, "webview", ".ui.tools.WebViewUI", paramPreference);
        break;
      }
    }
    label137:
    localg = new g();
    paramf = locala.HaX;
    if (paramf == null)
    {
      paramf = "";
      label168:
      localg.username = paramf;
      paramf = locala.HaX;
      if (paramf != null) {
        break label256;
      }
      paramf = "";
      label188:
      localg.qAF = paramf;
      paramf = locala.HaX;
      if (paramf != null) {
        break label274;
      }
    }
    label256:
    label274:
    for (int i = 1000;; i = paramf.YBS)
    {
      localg.scene = i;
      ((t)com.tencent.mm.kernel.h.ax(t.class)).a(locala.mContext, localg);
      break;
      paramPreference = paramf.YBP;
      paramf = paramPreference;
      if (paramPreference != null) {
        break label168;
      }
      paramf = "";
      break label168;
      paramPreference = paramf.YBQ;
      paramf = paramPreference;
      if (paramPreference != null) {
        break label188;
      }
      paramf = "";
      break label188;
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(364932);
    super.onResume();
    if (this.AuP)
    {
      this.AuP = false;
      AppMethodBeat.o(364932);
      return;
    }
    di localdi = new di(2);
    com.tencent.mm.kernel.h.aZW().a((p)localdi, 0);
    AppMethodBeat.o(364932);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    Object localObject = null;
    AppMethodBeat.i(364980);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onSceneEnd errType ").append(paramInt1).append(", errCode ").append(paramInt2).append(", errMsg ").append(paramString).append(" scene ");
    if (paramp == null)
    {
      paramString = null;
      Log.i(str, paramString + " scene:" + paramp);
      if (paramp != null) {
        break label120;
      }
    }
    label120:
    for (paramString = localObject;; paramString = Integer.valueOf(paramp.getType()))
    {
      if (paramString != null) {
        break label132;
      }
      AppMethodBeat.o(364980);
      return;
      paramString = Integer.valueOf(paramp.getType());
      break;
    }
    label132:
    if ((paramString.intValue() == 3761) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramp == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPrepareUser");
        AppMethodBeat.o(364980);
        throw paramString;
      }
      this.AwM = ((di)paramp).dVy();
      paramString = this.AwM;
      if (paramString != null)
      {
        this.BkY = paramString.aahF;
        kD(true);
      }
    }
    AppMethodBeat.o(364980);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderAccountManagent$Companion;", "", "()V", "ACCOUNT_EXTRA_CONFIG", "", "getACCOUNT_EXTRA_CONFIG", "()Ljava/lang/String;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderAccountManagent
 * JD-Core Version:    0.7.0.1
 */