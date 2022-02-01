package com.tencent.mm.plugin.festival.ui.bak;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.festival.a.a;
import com.tencent.mm.plugin.festival.a.b;
import com.tencent.mm.plugin.festival.a.c;
import com.tencent.mm.plugin.festival.a.d;
import com.tencent.mm.plugin.festival.ui.FestivalActivityBase;
import com.tencent.mm.plugin.finder.cgi.dt;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Calendar;
import kotlin.Metadata;

@com.tencent.mm.ui.base.a(32)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/festival/ui/bak/FestivalSecondBakUI;", "Lcom/tencent/mm/plugin/festival/ui/FestivalActivityBase;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "anchorUserName", "", "getContentLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setAuthInfo", "authProfession", "setFriendFollowCnt", "friendFollowCount", "showLiveEnd", "showLiveNotStart", "Companion", "plugin-festival_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FestivalSecondBakUI
  extends FestivalActivityBase
  implements com.tencent.mm.am.h
{
  public static final FestivalSecondBakUI.a Arj;
  private String mZs;
  
  static
  {
    AppMethodBeat.i(260916);
    Arj = new FestivalSecondBakUI.a((byte)0);
    AppMethodBeat.o(260916);
  }
  
  private final void MP(int paramInt)
  {
    AppMethodBeat.i(260908);
    ((TextView)findViewById(a.b.AqQ)).setText((CharSequence)getContext().getResources().getString(a.d.finder_friend_follow, new Object[] { r.TP(paramInt) }));
    if (paramInt > 0) {}
    for (paramInt = 0;; paramInt = 8)
    {
      ((TextView)findViewById(a.b.AqQ)).setVisibility(paramInt);
      ((LinearLayout)findViewById(a.b.AqR)).setVisibility(paramInt);
      AppMethodBeat.o(260908);
      return;
    }
  }
  
  private static final void a(FestivalSecondBakUI paramFestivalSecondBakUI, View paramView)
  {
    AppMethodBeat.i(260913);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFestivalSecondBakUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/festival/ui/bak/FestivalSecondBakUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFestivalSecondBakUI, "this$0");
    paramView = paramFestivalSecondBakUI.mZs;
    if (paramView != null)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("finder_username", paramView);
      ((Intent)localObject).putExtra("key_enter_profile_type", 11);
      ((cn)com.tencent.mm.kernel.h.az(cn.class)).enterFinderProfileUI((Context)paramFestivalSecondBakUI.getContext(), (Intent)localObject);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/festival/ui/bak/FestivalSecondBakUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(260913);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int dTn()
  {
    return a.c.Ara;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(260927);
    super.onCreate(paramBundle);
    switch (getIntent().getIntExtra("IntentKeyStatusErrorType", 1))
    {
    default: 
      finish();
      AppMethodBeat.o(260927);
      return;
    case 1: 
      ((RelativeLayout)findViewById(a.b.AqV)).setVisibility(0);
      ((LinearLayout)findViewById(a.b.AqW)).setVisibility(8);
      paramBundle = (RelativeLayout)findViewById(a.b.AqS);
      Object localObject = com.tencent.mm.plugin.festival.ui.a.Arh;
      localObject = (Context)this;
      kotlin.g.b.s.u(localObject, "context");
      com.tencent.mm.plugin.festival.ui.a.Ari.setTimeInMillis(System.currentTimeMillis());
      int i = com.tencent.mm.plugin.festival.ui.a.Ari.get(11);
      label152:
      label225:
      int j;
      if (6 <= i) {
        if (i < 18)
        {
          i = 1;
          if (i == 0) {
            break label462;
          }
          i = a.a.AqK;
          localObject = androidx.core.content.a.m((Context)localObject, i);
          kotlin.g.b.s.checkNotNull(localObject);
          paramBundle.setBackground((Drawable)new LayerDrawable(new Drawable[] { localObject }));
          this.mZs = getIntent().getStringExtra("IntentKeyAnchorUsrName");
          paramBundle = (CharSequence)this.mZs;
          if ((paramBundle != null) && (paramBundle.length() != 0)) {
            break label469;
          }
          i = 1;
          if (i != 0) {
            this.mZs = "v2_060000231003b20faec8cae38c11c0d5c60de432b07725973fcf0b69006c0940e35c83f58db4@finder";
          }
          paramBundle = (CharSequence)this.mZs;
          if ((paramBundle != null) && (paramBundle.length() != 0)) {
            break label474;
          }
          i = 1;
          label259:
          if (i != 0) {
            break label479;
          }
          ((TextView)findViewById(a.b.AqX)).setOnClickListener(new FestivalSecondBakUI..ExternalSyntheticLambda0(this));
          ((WeImageView)findViewById(a.b.AqY)).setVisibility(0);
          ((TextView)findViewById(a.b.AqX)).setVisibility(0);
          label312:
          ((ImageView)findViewById(a.b.AqO)).setImageResource(a.a.AqN);
          j = getIntent().getIntExtra("IntentKeyFriendFollowCnt", 0);
          paramBundle = (CharSequence)this.mZs;
          if ((paramBundle != null) && (paramBundle.length() != 0)) {
            break label512;
          }
        }
      }
      label512:
      for (i = 1;; i = 0)
      {
        if ((i != 0) || (j > 0)) {
          break label517;
        }
        com.tencent.mm.kernel.h.baD().mCm.a(3736, (com.tencent.mm.am.h)this);
        localObject = this.mZs;
        paramBundle = (Bundle)localObject;
        if (localObject == null) {
          paramBundle = "";
        }
        paramBundle = new dt(paramBundle, 0L, null, 0, null, 0, 0L, false, null, 0L, null, null, null, 8168);
        paramBundle.ADC = true;
        com.tencent.mm.kernel.h.aZW().a((p)paramBundle, 0);
        AppMethodBeat.o(260927);
        return;
        i = 0;
        break;
        i = 0;
        break;
        label462:
        i = a.a.AqL;
        break label152;
        label469:
        i = 0;
        break label225;
        label474:
        i = 0;
        break label259;
        label479:
        ((WeImageView)findViewById(a.b.AqY)).setVisibility(8);
        ((TextView)findViewById(a.b.AqX)).setVisibility(8);
        break label312;
      }
      label517:
      MP(j);
      AppMethodBeat.o(260927);
      return;
    }
    ((RelativeLayout)findViewById(a.b.AqS)).setBackground(getResources().getDrawable(a.a.AqM));
    ((RelativeLayout)findViewById(a.b.AqV)).setVisibility(8);
    ((LinearLayout)findViewById(a.b.AqW)).setVisibility(0);
    AppMethodBeat.o(260927);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(260930);
    Log.i("FestivalSecondBakUI", "onSceneEnd errType:" + paramInt1 + ", errCode:" + paramInt2 + ", scene:" + paramp);
    if ((paramp instanceof dt))
    {
      paramString = ((dt)paramp).caK();
      if ((((dt)paramp).ADC) && (kotlin.g.b.s.p(((dt)paramp).ABB, this.mZs)))
      {
        com.tencent.mm.kernel.h.baD().mCm.b(3736, (com.tencent.mm.am.h)this);
        if (paramString == null)
        {
          paramInt1 = 0;
          MP(paramInt1);
          if (paramString != null) {
            break label211;
          }
          paramString = null;
        }
        for (;;)
        {
          if (Util.isNullOrNil(paramString)) {
            break label233;
          }
          paramString = getContext().getResources().getString(a.d.finder_contact_auth, new Object[] { paramString });
          kotlin.g.b.s.s(paramString, "context.resources.getStr…act_auth, authProfession)");
          ((TextView)findViewById(a.b.AqP)).setText((CharSequence)paramString);
          ((TextView)findViewById(a.b.AqP)).setVisibility(0);
          AppMethodBeat.o(260930);
          return;
          paramInt1 = paramString.friend_follow_count;
          break;
          label211:
          paramString = paramString.authInfo;
          if (paramString == null) {
            paramString = null;
          } else {
            paramString = paramString.authProfession;
          }
        }
        label233:
        ((TextView)findViewById(a.b.AqP)).setVisibility(8);
      }
    }
    AppMethodBeat.o(260930);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.festival.ui.bak.FestivalSecondBakUI
 * JD-Core Version:    0.7.0.1
 */