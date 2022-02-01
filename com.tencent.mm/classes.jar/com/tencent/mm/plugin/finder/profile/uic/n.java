package com.tencent.mm.plugin.finder.profile.uic;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.loader.i;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.profile.uihandler.c;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.plugin.findersdk.a.ca;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileUiStyleUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "appBarLayout", "Landroid/view/View;", "bgContainer", "bgLevel1", "bgLevel2", "Landroid/widget/ImageView;", "bgLevel3", "coverColor", "", "coverPath", "", "coverSetEvent", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileUiStyleUIC$coverSetEvent$1", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileUiStyleUIC$coverSetEvent$1;", "coverUiConfig", "Lcom/tencent/mm/plugin/finder/profile/config/ProfileCoverConfig;", "curStyle", "descHeaderContainer", "profileContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "username", "getCoverGradient", "Landroid/graphics/drawable/GradientDrawable;", "extractColor", "getCoverInfo", "Lkotlin/Pair;", "coverUrl", "initViews", "", "invisibleBg", "isCovered", "", "onCreateAfter", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "refresh", "setCoverImage", "imageView", "setCoveredBg", "setCoveredStyle", "setNormalBg", "setNormalStyle", "visibleBg", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  extends UIComponent
{
  public static final a FfI;
  private int FfJ;
  private int FfK;
  private final com.tencent.mm.plugin.finder.profile.config.a FfL;
  private m FfM;
  private View FfN;
  private View FfO;
  private View FfP;
  private View FfQ;
  private ImageView FfR;
  private View FfS;
  private final FinderProfileUiStyleUIC.coverSetEvent.1 FfT;
  private String coverPath;
  private String username;
  
  static
  {
    AppMethodBeat.i(348978);
    FfI = new a((byte)0);
    AppMethodBeat.o(348978);
  }
  
  public n(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(348902);
    this.coverPath = "";
    this.FfK = -1;
    this.FfL = new com.tencent.mm.plugin.finder.profile.config.a(paramAppCompatActivity);
    this.username = "";
    this.FfT = new FinderProfileUiStyleUIC.coverSetEvent.1(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(348902);
  }
  
  private static final void a(String paramString, ImageView paramImageView, com.tencent.mm.loader.g.a.a parama, com.tencent.mm.loader.d.b.g paramg, Bitmap paramBitmap)
  {
    AppMethodBeat.i(348955);
    s.u(paramImageView, "$imageView");
    if (paramBitmap != null)
    {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(paramImageView));
      Log.i("Finder.ProfileUiStyleUIC", "[handleProfileCover] [" + paramBitmap.getWidth() + ':' + paramBitmap.getHeight() + "] allocationByteCount=" + Util.getSizeKB(paramBitmap.getAllocationByteCount()) + " coverUrl=" + paramString);
    }
    AppMethodBeat.o(348955);
  }
  
  private static r<String, Integer> azw(String paramString)
  {
    AppMethodBeat.i(348943);
    Object localObject;
    int i;
    if (!Util.isNullOrNil(paramString))
    {
      localObject = (CharSequence)paramString;
      i = ((CharSequence)localObject).length() - 1;
      if (i < 0) {
        break label228;
      }
      if (((CharSequence)localObject).charAt(i) != '&') {
        break label216;
      }
      j = 1;
      label44:
      if (j == 0) {
        break label221;
      }
    }
    label216:
    label221:
    label228:
    for (int j = i;; j = -1)
    {
      if (j != -1) {}
      try
      {
        localObject = Uri.parse(paramString);
        if (localObject == null) {
          i = 0;
        }
        for (;;)
        {
          paramString = paramString.subSequence(0, j).toString();
          Log.i("Finder.ProfileUiStyleUIC", "getCoverInfo bgColor:" + i + "  coverPath :" + paramString);
          paramString = new r(paramString, Integer.valueOf(i));
          AppMethodBeat.o(348943);
          return paramString;
          localObject = ((Uri)localObject).getQueryParameter("bgColor");
          if (localObject == null) {
            i = 0;
          } else {
            i = Integer.parseInt((String)localObject, 16);
          }
        }
        j = 0;
      }
      catch (NumberFormatException paramString)
      {
        Log.printErrStackTrace("Finder.ProfileUiStyleUIC", (Throwable)paramString, "", new Object[0]);
        AppMethodBeat.o(348943);
        return null;
      }
      catch (NullPointerException paramString)
      {
        for (;;)
        {
          Log.printErrStackTrace("Finder.ProfileUiStyleUIC", (Throwable)paramString, "", new Object[0]);
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Log.printErrStackTrace("Finder.ProfileUiStyleUIC", (Throwable)paramString, "", new Object[0]);
        }
      }
      break label44;
      i -= 1;
      break;
    }
  }
  
  private final void dTr()
  {
    AppMethodBeat.i(348908);
    Log.i("Finder.ProfileUiStyleUIC", "setCoveredStyle curStyle:" + this.FfJ + ' ');
    if (this.FfJ == 100)
    {
      AppMethodBeat.o(348908);
      return;
    }
    this.coverPath = "";
    this.FfK = -1;
    k localk = k.aeZF;
    ((a)k.d(getActivity()).q(a.class)).R(false, this.FfK);
    localk = k.aeZF;
    ((l)k.d(getActivity()).q(l.class)).tj(false);
    this.FfJ = 100;
    this.FfL.setStyle(100);
    eKw();
    AppMethodBeat.o(348908);
  }
  
  private final void eE(String paramString, int paramInt)
  {
    av localav = null;
    AppMethodBeat.i(348922);
    Object localObject2 = this.FfN;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("appBarLayout");
      localObject1 = null;
    }
    ((View)localObject1).setBackground(null);
    localObject2 = this.FfP;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("descHeaderContainer");
      localObject1 = null;
    }
    ((View)localObject1).setBackground(null);
    localObject2 = this.FfO;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("bgContainer");
      localObject1 = null;
    }
    ((View)localObject1).setVisibility(0);
    localObject2 = this.FfQ;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("bgLevel1");
      localObject1 = null;
    }
    ((View)localObject1).setBackgroundColor(paramInt);
    localObject2 = this.FfR;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("bgLevel2");
      localObject1 = null;
    }
    if (paramString == null)
    {
      localObject2 = "";
      localObject2 = new i((String)localObject2);
      p localp = p.ExI;
      localObject2 = p.eCl().dk(localObject2);
      localp = p.ExI;
      ((com.tencent.mm.loader.a.b)localObject2).a(p.a(p.a.ExU)).a(new n..ExternalSyntheticLambda0(paramString, (ImageView)localObject1)).d((ImageView)localObject1);
      localObject1 = this.FfS;
      if (localObject1 != null) {
        break label300;
      }
      s.bIx("bgLevel3");
      localObject1 = localav;
    }
    label300:
    for (;;)
    {
      localObject2 = new GradientDrawable();
      ((GradientDrawable)localObject2).setShape(0);
      ((GradientDrawable)localObject2).setGradientType(0);
      localav = av.GiL;
      ((GradientDrawable)localObject2).setColors(new int[] { av.e(0.0F, paramInt), paramInt });
      ((View)localObject1).setBackground((Drawable)localObject2);
      this.coverPath = paramString;
      AppMethodBeat.o(348922);
      return;
      localObject2 = paramString;
      break;
    }
  }
  
  private final void eF(String paramString, int paramInt)
  {
    AppMethodBeat.i(348928);
    Object localObject = k.aeZF;
    if (((h)k.d(getActivity()).q(h.class)).eJE())
    {
      Log.i("Finder.ProfileUiStyleUIC", "setCoveredStyle return for LogOutVisible");
      AppMethodBeat.o(348928);
      return;
    }
    if (((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu())
    {
      Log.i("Finder.ProfileUiStyleUIC", "setCoveredStyle return for isTeenMode");
      dTr();
      AppMethodBeat.o(348928);
      return;
    }
    Log.i("Finder.ProfileUiStyleUIC", "setCoveredStyle curStyle:" + this.FfJ + " coverPath:" + paramString + ", coverColor:" + paramInt);
    localObject = av.GiL;
    int i = av.e(0.4F, paramInt);
    localObject = av.GiL;
    paramInt = av.e(1.0F, paramInt);
    this.FfL.RF(i);
    localObject = k.aeZF;
    ((a)k.d(getActivity()).q(a.class)).R(true, paramInt);
    localObject = k.aeZF;
    ((l)k.d(getActivity()).q(l.class)).tj(true);
    this.FfL.setStyle(200);
    this.FfJ = 200;
    eE(paramString, paramInt);
    AppMethodBeat.o(348928);
  }
  
  private final void eKw()
  {
    Object localObject2 = null;
    AppMethodBeat.i(348915);
    Object localObject3 = this.FfO;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("bgContainer");
      localObject1 = null;
    }
    ((View)localObject1).setVisibility(8);
    localObject3 = this.FfQ;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("bgLevel1");
      localObject1 = null;
    }
    ((View)localObject1).setBackground(null);
    localObject3 = this.FfR;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("bgLevel2");
      localObject1 = null;
    }
    ((ImageView)localObject1).setImageDrawable(null);
    localObject3 = this.FfR;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("bgLevel2");
      localObject1 = null;
    }
    ((ImageView)localObject1).setVisibility(4);
    localObject3 = this.FfS;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("bgLevel3");
      localObject1 = null;
    }
    ((View)localObject1).setBackground(null);
    localObject1 = this.FfN;
    if (localObject1 == null)
    {
      s.bIx("appBarLayout");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((View)localObject1).setBackgroundColor(getActivity().getResources().getColor(e.b.BG_2));
      AppMethodBeat.o(348915);
      return;
    }
  }
  
  public final void azv(String paramString)
  {
    boolean bool1 = false;
    AppMethodBeat.i(349059);
    s.u(paramString, "username");
    Object localObject = com.tencent.mm.plugin.finder.api.d.AwY;
    this.FfM = d.a.auT(paramString);
    paramString = this.FfM;
    if (paramString == null)
    {
      paramString = null;
      if (paramString != null) {
        break label90;
      }
      if (((n)this).FfM == null) {
        break label85;
      }
    }
    label85:
    for (bool1 = true;; bool1 = false)
    {
      Log.w("Finder.ProfileUiStyleUIC", s.X("refresh  profileContact=", Boolean.valueOf(bool1)));
      AppMethodBeat.o(349059);
      return;
      paramString = paramString.field_authInfo;
      break;
    }
    label90:
    boolean bool2 = ((cn)com.tencent.mm.kernel.h.az(cn.class)).getFinderUtilApi().fgD();
    localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eUx().bmg()).intValue() == 1) {
      bool1 = true;
    }
    Log.i("Finder.ProfileUiStyleUIC", "isGlobalSetCoverOpen :" + bool2 + " isForceUpdateCover:" + bool1);
    localObject = this.FfM;
    if (localObject != null) {
      if (((bool2) && (paramString.authIconType == 2) && (((m)localObject).field_coverEntranceFlag == 1)) || (bool1))
      {
        Log.i("Finder.ProfileUiStyleUIC", "refresh getCoverInfo");
        localObject = ((m)localObject).dUD();
        paramString = (String)localObject;
        if (localObject == null) {
          paramString = "";
        }
        paramString = azw(paramString);
        if (paramString != null)
        {
          Log.i("Finder.ProfileUiStyleUIC", "refresh " + (String)paramString.bsC + "  " + ((Number)paramString.bsD).intValue());
          eF((String)paramString.bsC, ((Number)paramString.bsD).intValue());
          AppMethodBeat.o(349059);
        }
      }
      else
      {
        dTr();
      }
    }
    AppMethodBeat.o(349059);
  }
  
  public final boolean eKv()
  {
    return this.FfJ == 200;
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(349033);
    super.onCreateAfter(paramBundle);
    paramBundle = findViewById(e.e.appbarLayout);
    s.s(paramBundle, "findViewById(R.id.appbarLayout)");
    this.FfN = paramBundle;
    paramBundle = findViewById(e.e.finder_profile_bg_container);
    s.s(paramBundle, "findViewById(R.id.finder_profile_bg_container)");
    this.FfO = paramBundle;
    paramBundle = findViewById(e.e.finder_profile_bg_level1);
    s.s(paramBundle, "findViewById(R.id.finder_profile_bg_level1)");
    this.FfQ = paramBundle;
    paramBundle = findViewById(e.e.finder_profile_bg_level2);
    s.s(paramBundle, "findViewById(R.id.finder_profile_bg_level2)");
    this.FfR = ((ImageView)paramBundle);
    paramBundle = findViewById(e.e.finder_profile_bg_level3);
    s.s(paramBundle, "findViewById(R.id.finder_profile_bg_level3)");
    this.FfS = paramBundle;
    paramBundle = findViewById(e.e.header_desc_layout);
    s.s(paramBundle, "findViewById(R.id.header_desc_layout)");
    this.FfP = paramBundle;
    this.FfT.alive();
    paramBundle = this.FfL;
    paramBundle.Fck.add(Integer.valueOf(e.e.notice_part_line));
    paramBundle.Fcl.add(Integer.valueOf(e.e.profile_activity_text_split));
    paramBundle.Fch.add(Integer.valueOf(e.e.line));
    Object localObject = paramBundle.Fcm;
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_profile_follow_btn_tv));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.actionbar_follow_tv));
    paramBundle.Fci.add(Integer.valueOf(e.e.finder_profile_poi_list_layout));
    localObject = paramBundle.FbV;
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_live_notice_btn));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_profile_activity_name));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.edu_tips_layout_tv));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_live_notice_time_txt));
    localObject = paramBundle.FbU;
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_profile_friend_follow_tv));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.original_tag_tv));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.user_tag_layout));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_live_notice_desc_text));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_live_notice_count));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.profile_activity_participate_text));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.profile_activity_end_time_text));
    localObject = paramBundle.FbW;
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_profile_auth_by));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_profile_auth_generator_tv));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_profile_desc_tv));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_profile_fans_tv));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_profile_poi_name));
    localObject = paramBundle.FbT;
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_profile_name_tv));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.actionbar_nickname_tv));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.service_menu_title));
    localObject = paramBundle.FbX;
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_profile_mini_program_name));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.collapse_button_tv));
    paramBundle.Fca.add(Integer.valueOf(e.e.mini_program_icon));
    localObject = paramBundle.FbY;
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_profile_poi_name));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.media_entrance_name));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_profile_enterprise_add_name));
    localObject = paramBundle.Fce;
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_profile_followed_iv));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.actionbar_followed_iv));
    localObject = paramBundle.FbZ;
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_profile_poi_icon));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_profile_poi_list));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.media_entrance_icon));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_profile_poi_list));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.enterprise_add_icon));
    paramBundle.Fcb.add(Integer.valueOf(e.e.finder_live_notice_info_img));
    localObject = paramBundle.Fcd;
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_profile_edit_btn));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.moreIv));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.postBtnIv));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.backBtnIv));
    localObject = paramBundle.Fcf;
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_live_op_btn));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_profile_fans_icon));
    localObject = paramBundle.Fcg;
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_profile_activity_arrow));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_profile_fans_arrow));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_profile_desc_arrow));
    paramBundle.Fcj.add(Integer.valueOf(e.e.finder_profile_activity_info_img));
    localObject = paramBundle.Fcn;
    ((ArrayList)localObject).add(new r(Integer.valueOf(e.e.finder_profile_fans_icon), Integer.valueOf(e.g.icons_outlined_followed)));
    ((ArrayList)localObject).add(new r(Integer.valueOf(e.e.mini_program_icon), Integer.valueOf(e.g.icons_outlined_mini_program2)));
    ((ArrayList)localObject).add(new r(Integer.valueOf(e.e.finder_profile_poi_icon), Integer.valueOf(e.g.icons_outlined_location)));
    ((ArrayList)localObject).add(new r(Integer.valueOf(e.e.media_entrance_icon), Integer.valueOf(e.g.icons_outlined_official_accounts)));
    ((ArrayList)localObject).add(new r(Integer.valueOf(e.e.enterprise_add_icon), Integer.valueOf(e.g.icons_outlined_channels_enterprise_wechat)));
    localObject = paramBundle.FbN;
    ((ArrayList)localObject).add(Integer.valueOf(e.e.notice_part_line));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.profile_activity_text_split));
    localObject = paramBundle.FbO;
    ((ArrayList)localObject).add(Integer.valueOf(e.e.line));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_profile_poi_list_layout));
    localObject = paramBundle.FbG;
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_profile_followed_iv));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.actionbar_followed_iv));
    localObject = paramBundle.FbI;
    ((ArrayList)localObject).add(Integer.valueOf(e.e.actionbar_nickname_tv));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_profile_activity_name));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_live_notice_time_txt));
    localObject = paramBundle.FbL;
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_profile_follow_btn_tv));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.actionbar_follow_tv));
    localObject = paramBundle.FbJ;
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_profile_auth_by));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_profile_auth_generator_tv));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_profile_desc_tv));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_profile_fans_tv));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_profile_friend_follow_tv));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.media_entrance_name));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_profile_enterprise_add_name));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_profile_mini_program_name));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_profile_poi_name));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_live_notice_btn));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_live_notice_desc_text));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.edu_tips_layout_tv));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.service_menu_title));
    localObject = paramBundle.FbK;
    ((ArrayList)localObject).add(Integer.valueOf(e.e.original_tag_tv));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.user_tag_layout));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_live_notice_count));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.profile_activity_participate_text));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.profile_activity_end_time_text));
    localObject = paramBundle.FbC;
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_profile_block_icon));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_profile_fans_icon));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_profile_poi_icon));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.media_entrance_icon));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.enterprise_add_icon));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_profile_poi_list));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.mini_program_icon));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_profile_block_icon));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_live_notice_info_img));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_live_op_btn));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_profile_activity_info_img));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_profile_poi_list));
    localObject = paramBundle.FbD;
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_profile_desc_arrow));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_profile_fans_arrow));
    paramBundle.FbE.add(Integer.valueOf(e.e.finder_profile_activity_arrow));
    localObject = paramBundle.FbF;
    ((ArrayList)localObject).add(Integer.valueOf(e.e.backBtnIv));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.postBtnIv));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.moreIv));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_profile_edit_btn));
    localObject = paramBundle.FbH;
    ((ArrayList)localObject).add(Integer.valueOf(e.e.finder_profile_name_tv));
    ((ArrayList)localObject).add(Integer.valueOf(e.e.collapse_button_tv));
    localObject = paramBundle.Fco;
    ((ArrayList)localObject).add(new r(Integer.valueOf(e.e.finder_profile_fans_icon), Integer.valueOf(e.g.icons_filled_follow)));
    ((ArrayList)localObject).add(new r(Integer.valueOf(e.e.mini_program_icon), Integer.valueOf(e.g.icons_filled_mini_program2)));
    ((ArrayList)localObject).add(new r(Integer.valueOf(e.e.finder_profile_poi_icon), Integer.valueOf(e.g.icons_filled_location)));
    ((ArrayList)localObject).add(new r(Integer.valueOf(e.e.media_entrance_icon), Integer.valueOf(e.g.icons_filled_official_accounts)));
    ((ArrayList)localObject).add(new r(Integer.valueOf(e.e.enterprise_add_icon), Integer.valueOf(e.g.icons_filled_channels_enterprise_wechat)));
    paramBundle.Fbz.a(Integer.valueOf(100), (Set)ar.an(new com.tencent.mm.plugin.finder.profile.uihandler.b[] { (com.tencent.mm.plugin.finder.profile.uihandler.b)new com.tencent.mm.plugin.finder.profile.uihandler.h(paramBundle.activity, (List)paramBundle.Fcn), (com.tencent.mm.plugin.finder.profile.uihandler.b)new com.tencent.mm.plugin.finder.profile.uihandler.f(paramBundle.activity, paramBundle.Fbx, (List)paramBundle.Fck), (com.tencent.mm.plugin.finder.profile.uihandler.b)new com.tencent.mm.plugin.finder.profile.uihandler.f(paramBundle.activity, paramBundle.Fbs, (List)paramBundle.Fcl), (com.tencent.mm.plugin.finder.profile.uihandler.b)new com.tencent.mm.plugin.finder.profile.uihandler.f(paramBundle.activity, paramBundle.Fbr, (List)paramBundle.Fch), (com.tencent.mm.plugin.finder.profile.uihandler.b)new com.tencent.mm.plugin.finder.profile.uihandler.f(paramBundle.activity, paramBundle.Fby, (List)paramBundle.Fci), (com.tencent.mm.plugin.finder.profile.uihandler.b)new com.tencent.mm.plugin.finder.profile.uihandler.d(paramBundle.activity, paramBundle.Fbf, (List)paramBundle.Fcm), (com.tencent.mm.plugin.finder.profile.uihandler.b)new com.tencent.mm.plugin.finder.profile.uihandler.d(paramBundle.activity, paramBundle.Fbm, (List)paramBundle.FbS), (com.tencent.mm.plugin.finder.profile.uihandler.b)new com.tencent.mm.plugin.finder.profile.uihandler.d(paramBundle.activity, paramBundle.Fbp, (List)paramBundle.FbV), (com.tencent.mm.plugin.finder.profile.uihandler.b)new com.tencent.mm.plugin.finder.profile.uihandler.d(paramBundle.activity, paramBundle.Fbr, (List)paramBundle.FbU), (com.tencent.mm.plugin.finder.profile.uihandler.b)new com.tencent.mm.plugin.finder.profile.uihandler.d(paramBundle.activity, paramBundle.Fbo, (List)paramBundle.FbW), (com.tencent.mm.plugin.finder.profile.uihandler.b)new com.tencent.mm.plugin.finder.profile.uihandler.d(paramBundle.activity, paramBundle.Fbn, (List)paramBundle.FbT), (com.tencent.mm.plugin.finder.profile.uihandler.b)new com.tencent.mm.plugin.finder.profile.uihandler.d(paramBundle.activity, paramBundle.linkColor, (List)paramBundle.FbX), (com.tencent.mm.plugin.finder.profile.uihandler.b)new com.tencent.mm.plugin.finder.profile.uihandler.d(paramBundle.activity, paramBundle.Fbt, (List)paramBundle.FbY), (com.tencent.mm.plugin.finder.profile.uihandler.b)new com.tencent.mm.plugin.finder.profile.uihandler.g(paramBundle.activity, Integer.valueOf(paramBundle.Fbv), (List)paramBundle.Fca, null, 8), (com.tencent.mm.plugin.finder.profile.uihandler.b)new com.tencent.mm.plugin.finder.profile.uihandler.g(paramBundle.activity, Integer.valueOf(paramBundle.Fbt), (List)paramBundle.FbZ, null, 8), (com.tencent.mm.plugin.finder.profile.uihandler.b)new com.tencent.mm.plugin.finder.profile.uihandler.g(paramBundle.activity, Integer.valueOf(paramBundle.Fbu), (List)paramBundle.Fcb, null, 8), (com.tencent.mm.plugin.finder.profile.uihandler.b)new com.tencent.mm.plugin.finder.profile.uihandler.g(paramBundle.activity, Integer.valueOf(paramBundle.Fbp), (List)paramBundle.Fcd, null, 8), (com.tencent.mm.plugin.finder.profile.uihandler.b)new com.tencent.mm.plugin.finder.profile.uihandler.g(paramBundle.activity, Integer.valueOf(paramBundle.Fbq), (List)paramBundle.Fce, null, 8), (com.tencent.mm.plugin.finder.profile.uihandler.b)new com.tencent.mm.plugin.finder.profile.uihandler.g(paramBundle.activity, Integer.valueOf(paramBundle.Fbr), (List)paramBundle.Fcf, null, 8), (com.tencent.mm.plugin.finder.profile.uihandler.b)new com.tencent.mm.plugin.finder.profile.uihandler.g(paramBundle.activity, Integer.valueOf(paramBundle.Fbs), (List)paramBundle.Fcg, null, 8), (com.tencent.mm.plugin.finder.profile.uihandler.b)new com.tencent.mm.plugin.finder.profile.uihandler.g(paramBundle.activity, Integer.valueOf(paramBundle.Fbw), (List)paramBundle.Fcj, null, 8), (com.tencent.mm.plugin.finder.profile.uihandler.b)new com.tencent.mm.plugin.finder.profile.uihandler.g(paramBundle.activity, null, (List)paramBundle.Fcc, null, 8), (com.tencent.mm.plugin.finder.profile.uihandler.b)new c(paramBundle.activity, false, "ProfileStyle", 0) }));
    paramBundle.FbA = new com.tencent.mm.plugin.finder.profile.uihandler.d(paramBundle.activity, (List)paramBundle.FbQ);
    paramBundle.FbB = new com.tencent.mm.plugin.finder.profile.uihandler.g(paramBundle.activity, null, (List)paramBundle.FbR, "extractColorIcon", 2);
    localObject = getActivity().getIntent().getStringExtra("finder_username");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    this.username = paramBundle;
    azv(this.username);
    AppMethodBeat.o(349033);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(349040);
    super.onDestroy();
    this.FfT.dead();
    AppMethodBeat.o(349040);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileUiStyleUIC$Companion;", "", "()V", "IS_FORCE_COVER", "", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(ImageView paramImageView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uic.n
 * JD-Core Version:    0.7.0.1
 */