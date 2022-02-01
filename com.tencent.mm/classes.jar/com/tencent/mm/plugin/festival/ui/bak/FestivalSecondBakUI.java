package com.tencent.mm.plugin.festival.ui.bak;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.festival.a.a;
import com.tencent.mm.plugin.festival.a.b;
import com.tencent.mm.plugin.festival.a.c;
import com.tencent.mm.plugin.festival.a.d;
import com.tencent.mm.plugin.festival.ui.FestivalActivityBase;
import com.tencent.mm.plugin.finder.cgi.cr;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Calendar;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@com.tencent.mm.ui.base.a(32)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/festival/ui/bak/FestivalSecondBakUI;", "Lcom/tencent/mm/plugin/festival/ui/FestivalActivityBase;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "anchorUserName", "", "getContentLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setAuthInfo", "authProfession", "setFriendFollowCnt", "friendFollowCount", "showLiveEnd", "showLiveNotStart", "Companion", "plugin-festival_release"})
public final class FestivalSecondBakUI
  extends FestivalActivityBase
  implements i
{
  public static final a wUD;
  private HashMap _$_findViewCache;
  private String kvQ;
  
  static
  {
    AppMethodBeat.i(258658);
    wUD = new a((byte)0);
    AppMethodBeat.o(258658);
  }
  
  private final void LS(int paramInt)
  {
    AppMethodBeat.i(258657);
    Object localObject = (TextView)_$_findCachedViewById(a.b.anchor_ext_info_friend_floow_count);
    p.j(localObject, "anchor_ext_info_friend_floow_count");
    AppCompatActivity localAppCompatActivity = getContext();
    p.j(localAppCompatActivity, "context");
    ((TextView)localObject).setText((CharSequence)localAppCompatActivity.getResources().getString(a.d.finder_friend_follow, new Object[] { m.QF(paramInt) }));
    if (paramInt > 0) {}
    for (paramInt = 0;; paramInt = 8)
    {
      localObject = (TextView)_$_findCachedViewById(a.b.anchor_ext_info_friend_floow_count);
      p.j(localObject, "anchor_ext_info_friend_floow_count");
      ((TextView)localObject).setVisibility(paramInt);
      localObject = (LinearLayout)_$_findCachedViewById(a.b.anchor_ext_info_layout);
      p.j(localObject, "anchor_ext_info_layout");
      ((LinearLayout)localObject).setVisibility(paramInt);
      AppMethodBeat.o(258657);
      return;
    }
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(258662);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(258662);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(258660);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(258660);
    return localView1;
  }
  
  public final int dmv()
  {
    return a.c.wUr;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(258647);
    super.onCreate(paramBundle);
    switch (getIntent().getIntExtra("IntentKeyStatusErrorType", 1))
    {
    default: 
      finish();
      AppMethodBeat.o(258647);
      return;
    case 1: 
      paramBundle = (RelativeLayout)_$_findCachedViewById(a.b.wUo);
      p.j(paramBundle, "liveStatusEndRoot");
      paramBundle.setVisibility(0);
      paramBundle = (LinearLayout)_$_findCachedViewById(a.b.wUp);
      p.j(paramBundle, "liveStatusNotStartRoot");
      paramBundle.setVisibility(8);
      paramBundle = (RelativeLayout)_$_findCachedViewById(a.b.wUl);
      p.j(paramBundle, "bgRoot");
      Object localObject = com.tencent.mm.plugin.festival.ui.a.wUC;
      localObject = (Context)this;
      p.k(localObject, "context");
      Calendar localCalendar = com.tencent.mm.plugin.festival.ui.a.wUB;
      p.j(localCalendar, "calender");
      localCalendar.setTimeInMillis(System.currentTimeMillis());
      int i = com.tencent.mm.plugin.festival.ui.a.wUB.get(11);
      label171:
      label179:
      label255:
      int j;
      if (6 > i)
      {
        i = 0;
        if (i == 0) {
          break label515;
        }
        i = a.a.wUh;
        localObject = androidx.core.content.a.m((Context)localObject, i);
        if (localObject == null) {
          p.iCn();
        }
        paramBundle.setBackground((Drawable)new LayerDrawable(new Drawable[] { localObject }));
        this.kvQ = getIntent().getStringExtra("IntentKeyAnchorUsrName");
        paramBundle = (CharSequence)this.kvQ;
        if ((paramBundle != null) && (paramBundle.length() != 0)) {
          break label522;
        }
        i = 1;
        if (i != 0) {
          this.kvQ = "v2_060000231003b20faec8cae38c11c0d5c60de432b07725973fcf0b69006c0940e35c83f58db4@finder";
        }
        paramBundle = (CharSequence)this.kvQ;
        if ((paramBundle != null) && (paramBundle.length() != 0)) {
          break label527;
        }
        i = 1;
        label289:
        if (i != 0) {
          break label532;
        }
        ((TextView)_$_findCachedViewById(a.b.visit_anchor_profile)).setOnClickListener((View.OnClickListener)new FestivalSecondBakUI.b(this));
        paramBundle = (WeImageView)_$_findCachedViewById(a.b.visit_anchor_profile_icon);
        p.j(paramBundle, "visit_anchor_profile_icon");
        paramBundle.setVisibility(0);
        paramBundle = (TextView)_$_findCachedViewById(a.b.visit_anchor_profile);
        p.j(paramBundle, "visit_anchor_profile");
        paramBundle.setVisibility(0);
        label363:
        ((ImageView)_$_findCachedViewById(a.b.anchor_avatar)).setImageResource(a.a.wUk);
        j = getIntent().getIntExtra("IntentKeyFriendFollowCnt", 0);
        paramBundle = (CharSequence)this.kvQ;
        if ((paramBundle != null) && (paramBundle.length() != 0)) {
          break label583;
        }
      }
      label515:
      label522:
      label527:
      label532:
      label583:
      for (i = 1;; i = 0)
      {
        if ((i != 0) || (j > 0)) {
          break label588;
        }
        paramBundle = h.aHF();
        p.j(paramBundle, "MMKernel.network()");
        paramBundle.aGY().a(3736, (i)this);
        localObject = this.kvQ;
        paramBundle = (Bundle)localObject;
        if (localObject == null) {
          paramBundle = "";
        }
        paramBundle = new cr(paramBundle, 0L, null, 0, null, 0, 0L, 104);
        paramBundle.xer = true;
        h.aGY().b((q)paramBundle);
        AppMethodBeat.o(258647);
        return;
        if (18 <= i) {
          break;
        }
        i = 1;
        break label171;
        i = a.a.wUi;
        break label179;
        i = 0;
        break label255;
        i = 0;
        break label289;
        paramBundle = (WeImageView)_$_findCachedViewById(a.b.visit_anchor_profile_icon);
        p.j(paramBundle, "visit_anchor_profile_icon");
        paramBundle.setVisibility(8);
        paramBundle = (TextView)_$_findCachedViewById(a.b.visit_anchor_profile);
        p.j(paramBundle, "visit_anchor_profile");
        paramBundle.setVisibility(8);
        break label363;
      }
      label588:
      LS(j);
      AppMethodBeat.o(258647);
      return;
    }
    paramBundle = (RelativeLayout)_$_findCachedViewById(a.b.wUl);
    p.j(paramBundle, "bgRoot");
    paramBundle.setBackground(getResources().getDrawable(a.a.wUj));
    paramBundle = (RelativeLayout)_$_findCachedViewById(a.b.wUo);
    p.j(paramBundle, "liveStatusEndRoot");
    paramBundle.setVisibility(8);
    paramBundle = (LinearLayout)_$_findCachedViewById(a.b.wUp);
    p.j(paramBundle, "liveStatusNotStartRoot");
    paramBundle.setVisibility(0);
    AppMethodBeat.o(258647);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(258655);
    Log.i("FestivalSecondBakUI", "onSceneEnd errType:" + paramInt1 + ", errCode:" + paramInt2 + ", scene:" + paramq);
    if ((paramq instanceof cr))
    {
      paramString = ((cr)paramq).dpc();
      if ((((cr)paramq).xer) && (p.h(((cr)paramq).xcq, this.kvQ)))
      {
        paramq = h.aHF();
        p.j(paramq, "MMKernel.network()");
        paramq.aGY().b(3736, (i)this);
        if (paramString != null)
        {
          paramInt1 = paramString.friend_follow_count;
          LS(paramInt1);
          if (paramString == null) {
            break label267;
          }
          paramString = paramString.authInfo;
          if (paramString == null) {
            break label267;
          }
        }
        label267:
        for (paramString = paramString.authProfession;; paramString = null)
        {
          if (Util.isNullOrNil(paramString)) {
            break label272;
          }
          paramq = getContext();
          p.j(paramq, "context");
          paramString = paramq.getResources().getString(a.d.finder_contact_auth, new Object[] { paramString });
          p.j(paramString, "context.resources.getStr…act_auth, authProfession)");
          paramq = (TextView)_$_findCachedViewById(a.b.anchor_ext_info_auth);
          p.j(paramq, "anchor_ext_info_auth");
          paramq.setText((CharSequence)paramString);
          paramString = (TextView)_$_findCachedViewById(a.b.anchor_ext_info_auth);
          p.j(paramString, "anchor_ext_info_auth");
          paramString.setVisibility(0);
          AppMethodBeat.o(258655);
          return;
          paramInt1 = 0;
          break;
        }
        label272:
        paramString = (TextView)_$_findCachedViewById(a.b.anchor_ext_info_auth);
        p.j(paramString, "anchor_ext_info_auth");
        paramString.setVisibility(8);
      }
    }
    AppMethodBeat.o(258655);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/festival/ui/bak/FestivalSecondBakUI$Companion;", "", "()V", "BakAnchorUserName", "", "IntentKeyAnchorUsrName", "IntentKeyFriendFollowCnt", "IntentKeyStatusErrorType", "StatusErrorTypeLiveEnd", "", "StatusErrorTypeLiveNotStart", "TAG", "plugin-festival_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.festival.ui.bak.FestivalSecondBakUI
 * JD-Core Version:    0.7.0.1
 */