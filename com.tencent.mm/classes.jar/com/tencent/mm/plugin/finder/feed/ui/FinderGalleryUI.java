package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.fh;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.gallery.b.a;
import com.tencent.mm.plugin.finder.gallery.j;
import com.tencent.mm.plugin.finder.gallery.k;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.report.v;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.view.FinderViewPager;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderGalleryUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "MENU_POST", "", "MENU_SEARCH_ID", "TAG", "", "galleryConfig", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig;", "getGalleryConfig", "()Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig;", "setGalleryConfig", "(Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig;)V", "galleryCore", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryCore;", "getGalleryCore", "()Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryCore;", "setGalleryCore", "(Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryCore;)V", "checkPermission", "", "checkShowPostBtn", "", "getLayoutId", "hasExtStatusFlag", "flag", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderGalleryUI
  extends MMFinderUI
{
  public com.tencent.mm.plugin.finder.gallery.c BnP;
  private final int BnQ = 1;
  private final int BnR = 2;
  public com.tencent.mm.plugin.finder.gallery.b Bnx;
  private final String TAG = "Finder.FinderGalleryUI";
  
  private static final void a(FinderGalleryUI paramFinderGalleryUI, com.tencent.mm.ui.base.s params)
  {
    Object localObject = null;
    AppMethodBeat.i(365606);
    kotlin.g.b.s.u(paramFinderGalleryUI, "this$0");
    if (params.jmw())
    {
      params.oh(1001, e.h.app_field_mmsight);
      params.oh(1002, e.h.app_field_select_new_pic);
    }
    params = com.tencent.mm.plugin.finder.report.z.FrZ;
    params = as.GSQ;
    params = paramFinderGalleryUI.getContext();
    kotlin.g.b.s.s(params, "context");
    params = as.a.hu((Context)params);
    if (params == null)
    {
      params = null;
      com.tencent.mm.plugin.finder.report.z.b(0, "post_acionsheet_camera", "", params);
      params = com.tencent.mm.plugin.finder.report.z.FrZ;
      params = as.GSQ;
      paramFinderGalleryUI = paramFinderGalleryUI.getContext();
      kotlin.g.b.s.s(paramFinderGalleryUI, "context");
      paramFinderGalleryUI = as.a.hu((Context)paramFinderGalleryUI);
      if (paramFinderGalleryUI != null) {
        break label140;
      }
    }
    label140:
    for (paramFinderGalleryUI = localObject;; paramFinderGalleryUI = paramFinderGalleryUI.fou())
    {
      com.tencent.mm.plugin.finder.report.z.b(0, "post_actionsheet_album", "", paramFinderGalleryUI);
      AppMethodBeat.o(365606);
      return;
      params = params.fou();
      break;
    }
  }
  
  private static final void a(FinderGalleryUI paramFinderGalleryUI, String paramString, AppCompatActivity paramAppCompatActivity, MenuItem paramMenuItem, int paramInt)
  {
    Object localObject = null;
    AppMethodBeat.i(365615);
    kotlin.g.b.s.u(paramFinderGalleryUI, "this$0");
    kotlin.g.b.s.u(paramString, "$postId");
    Intent localIntent = new Intent();
    if (paramMenuItem.getItemId() == 1001)
    {
      localIntent.putExtra("key_finder_post_router", 2);
      paramMenuItem = com.tencent.mm.plugin.finder.report.z.FrZ;
      paramMenuItem = as.GSQ;
      paramFinderGalleryUI = paramFinderGalleryUI.getContext();
      kotlin.g.b.s.s(paramFinderGalleryUI, "context");
      paramFinderGalleryUI = as.a.hu((Context)paramFinderGalleryUI);
      if (paramFinderGalleryUI == null)
      {
        paramFinderGalleryUI = null;
        com.tencent.mm.plugin.finder.report.z.b(1, "post_acionsheet_camera", "", paramFinderGalleryUI);
      }
    }
    while (paramMenuItem.getItemId() != 1002) {
      for (;;)
      {
        localIntent.putExtra("key_finder_post_from", 12);
        localIntent.putExtra("key_finder_post_id", paramString);
        paramFinderGalleryUI = com.tencent.mm.plugin.finder.utils.a.GfO;
        kotlin.g.b.s.s(paramAppCompatActivity, "activity");
        com.tencent.mm.plugin.finder.utils.a.enterFinderPostRouterUI((Context)paramAppCompatActivity, localIntent);
        paramFinderGalleryUI = v.FrN;
        v.aP(14, false);
        AppMethodBeat.o(365615);
        return;
        paramFinderGalleryUI = paramFinderGalleryUI.fou();
      }
    }
    localIntent.putExtra("key_finder_post_router", 3);
    paramMenuItem = com.tencent.mm.plugin.finder.report.z.FrZ;
    paramMenuItem = as.GSQ;
    paramFinderGalleryUI = paramFinderGalleryUI.getContext();
    kotlin.g.b.s.s(paramFinderGalleryUI, "context");
    paramFinderGalleryUI = as.a.hu((Context)paramFinderGalleryUI);
    if (paramFinderGalleryUI == null) {}
    for (paramFinderGalleryUI = localObject;; paramFinderGalleryUI = paramFinderGalleryUI.fou())
    {
      com.tencent.mm.plugin.finder.report.z.b(1, "post_actionsheet_album", "", paramFinderGalleryUI);
      break;
    }
  }
  
  private static final boolean a(FinderGalleryUI paramFinderGalleryUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(365586);
    kotlin.g.b.s.u(paramFinderGalleryUI, "this$0");
    paramFinderGalleryUI.eeT();
    paramFinderGalleryUI.finish();
    AppMethodBeat.o(365586);
    return true;
  }
  
  private static final boolean b(FinderGalleryUI paramFinderGalleryUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(365597);
    kotlin.g.b.s.u(paramFinderGalleryUI, "this$0");
    paramMenuItem = new Intent(paramFinderGalleryUI.getIntent());
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.GfO;
    com.tencent.mm.plugin.finder.utils.a.ap((Context)paramFinderGalleryUI, paramMenuItem);
    paramFinderGalleryUI = com.tencent.mm.plugin.finder.gallery.f.BuT;
    paramFinderGalleryUI = new fh();
    paramFinderGalleryUI.pO(com.tencent.mm.plugin.finder.gallery.f.sessionId);
    paramFinderGalleryUI.iGT = com.tencent.mm.plugin.finder.gallery.f.BuU;
    paramFinderGalleryUI.iFe = 2L;
    paramFinderGalleryUI.pP("search_icon");
    paramFinderGalleryUI.iGV = com.tencent.mm.plugin.finder.gallery.f.BuV;
    paramFinderGalleryUI.pQ("");
    paramFinderGalleryUI.pR(String.valueOf(com.tencent.mm.model.cn.bDw()));
    paramFinderGalleryUI.bMH();
    com.tencent.mm.plugin.finder.gallery.f.a((com.tencent.mm.plugin.report.a)paramFinderGalleryUI);
    AppMethodBeat.o(365597);
    return true;
  }
  
  private static final boolean c(FinderGalleryUI paramFinderGalleryUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(365645);
    kotlin.g.b.s.u(paramFinderGalleryUI, "this$0");
    paramMenuItem = paramFinderGalleryUI.getContext();
    Object localObject1 = new StringBuilder();
    h.baC();
    localObject1 = com.tencent.mm.kernel.b.aZs() + '_' + Util.nowMilliSecond();
    com.tencent.mm.ui.widget.a.f localf = new com.tencent.mm.ui.widget.a.f((Context)paramMenuItem, 1, true);
    Object localObject2 = av.GiL;
    if (av.ffR())
    {
      localObject2 = af.mU((Context)paramMenuItem).inflate(e.f.finder_sheet_header, null);
      Object localObject5 = (TextView)((View)localObject2).findViewById(e.e.nickname);
      Object localObject3 = (ImageView)((View)localObject2).findViewById(e.e.avatar);
      Object localObject4 = com.tencent.mm.plugin.finder.api.d.AwY;
      localObject4 = d.a.auT(com.tencent.mm.model.z.bAW());
      if (localObject4 != null)
      {
        ((TextView)localObject5).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)paramMenuItem, (CharSequence)((m)localObject4).getNickname()));
        localObject5 = com.tencent.mm.plugin.finder.loader.p.ExI;
        localObject5 = com.tencent.mm.plugin.finder.loader.p.eCp();
        com.tencent.mm.plugin.finder.loader.b localb = new com.tencent.mm.plugin.finder.loader.b(((m)localObject4).field_avatarUrl);
        kotlin.g.b.s.s(localObject3, "avatarIv");
        com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
        ((com.tencent.mm.loader.d)localObject5).a(localb, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
        localObject3 = av.GiL;
        kotlin.g.b.s.s(localObject2, "headerView");
        av.a((m)localObject4, (View)localObject2);
      }
      localf.af((View)localObject2, true);
    }
    localObject2 = v.FrN;
    v.azP((String)localObject1);
    localf.Vtg = new FinderGalleryUI..ExternalSyntheticLambda3(paramFinderGalleryUI);
    localf.GAC = new FinderGalleryUI..ExternalSyntheticLambda4(paramFinderGalleryUI, (String)localObject1, paramMenuItem);
    localf.aeLi = FinderGalleryUI..ExternalSyntheticLambda5.INSTANCE;
    localf.dDn();
    AppMethodBeat.o(365645);
    return true;
  }
  
  private com.tencent.mm.plugin.finder.gallery.b eeT()
  {
    AppMethodBeat.i(365582);
    com.tencent.mm.plugin.finder.gallery.b localb = this.Bnx;
    if (localb != null)
    {
      AppMethodBeat.o(365582);
      return localb;
    }
    kotlin.g.b.s.bIx("galleryConfig");
    AppMethodBeat.o(365582);
    return null;
  }
  
  private static final void eeW()
  {
    AppMethodBeat.i(365624);
    v localv = v.FrN;
    v.SA(6);
    AppMethodBeat.o(365624);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return e.f.finder_gallery_common_ui;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(365719);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    eeT().a((MMActivity)this, paramInt1, paramInt2, paramIntent, com.tencent.mm.plugin.finder.gallery.b.b.Buu);
    AppMethodBeat.o(365719);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    int k = 0;
    AppMethodBeat.i(365707);
    super.onCreate(paramBundle);
    hideActionbarLine();
    setBackBtn(new FinderGalleryUI..ExternalSyntheticLambda2(this));
    Object localObject = getIntent().getStringExtra("TITLE");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    Log.i(this.TAG, kotlin.g.b.s.X("onCreate, title:", paramBundle));
    int i;
    label92:
    boolean bool3;
    label311:
    boolean bool2;
    label318:
    boolean bool1;
    label444:
    int j;
    if (((CharSequence)paramBundle).length() == 0)
    {
      i = 1;
      if (i == 0) {
        break label488;
      }
      setMMTitle(e.h.finder_select_from_finder);
      paramBundle = (ViewGroup)findViewById(e.e.gallery_core_root);
      localObject = com.tencent.mm.plugin.finder.gallery.b.Bus;
      localObject = getIntent();
      kotlin.g.b.s.s(localObject, "intent");
      localObject = b.a.au((Intent)localObject);
      kotlin.g.b.s.u(localObject, "<set-?>");
      this.Bnx = ((com.tencent.mm.plugin.finder.gallery.b)localObject);
      localObject = (MMActivity)this;
      kotlin.g.b.s.s(paramBundle, "coreRoot");
      localObject = new com.tencent.mm.plugin.finder.gallery.c((MMActivity)localObject, paramBundle, eeT());
      kotlin.g.b.s.u(localObject, "<set-?>");
      this.BnP = ((com.tencent.mm.plugin.finder.gallery.c)localObject);
      if (eeT().egw())
      {
        setActionbarColor(getResources().getColor(com.tencent.mm.plugin.gallery.b.b.Dark_5));
        paramBundle.setBackgroundColor(getResources().getColor(com.tencent.mm.plugin.gallery.b.b.Dark_5));
      }
      if (((bw)h.ax(bw.class)).aBu()) {
        break label564;
      }
      addIconOptionMenu(this.BnQ, -1, e.g.icons_outlined_search, new FinderGalleryUI..ExternalSyntheticLambda1(this));
      if (eeT().But.BsZ.contains(Integer.valueOf(5)))
      {
        bool3 = ((com.tencent.mm.plugin.findersdk.a.cn)h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).showFinderEntry();
        if ((com.tencent.mm.model.z.bAR() & 0x0) == 0L) {
          break label496;
        }
        i = 1;
        if (i != 0) {
          break label501;
        }
        bool2 = true;
        paramBundle = av.GiL;
        i = av.fgg();
        bool1 = ((bw)h.ax(bw.class)).aBu();
        Log.i(this.TAG, "checkPermission show:" + bool3 + ", open:" + bool2 + ", state:" + i + ", teenMode:" + bool1);
        paramBundle = com.tencent.mm.plugin.finder.storage.d.FAy;
        switch (((Number)com.tencent.mm.plugin.finder.storage.d.eSs().bmg()).intValue())
        {
        default: 
          if (!bool3) {
            j = k;
          }
          break;
        }
      }
    }
    for (;;)
    {
      if (j != 0) {
        addIconOptionMenu(this.BnR, -1, e.g.icons_outlined_camera, new FinderGalleryUI..ExternalSyntheticLambda0(this));
      }
      AppMethodBeat.o(365707);
      return;
      i = 0;
      break;
      label488:
      setMMTitle(paramBundle);
      break label92;
      label496:
      i = 0;
      break label311;
      label501:
      bool2 = false;
      break label318;
      bool3 = false;
      break label444;
      i = 1;
      break label444;
      bool2 = false;
      break label444;
      bool1 = true;
      break label444;
      j = k;
      if (bool2) {
        if (i != 2)
        {
          j = k;
          if (i != 3) {}
        }
        else
        {
          j = k;
          if (!bool1) {
            j = 1;
          }
        }
      }
    }
    label564:
    Log.i(this.TAG, "onCreate isTeenMode:" + ((bw)h.ax(bw.class)).aBu() + " isTeenModeAndViewAll:" + ((bw)h.ax(bw.class)).eZE());
    AppMethodBeat.o(365707);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(365728);
    Object localObject = this.BnP;
    int i;
    if (localObject != null)
    {
      if (((com.tencent.mm.plugin.finder.gallery.c)localObject).BuA >= 0) {
        ((com.tencent.mm.plugin.finder.publish.c)h.az(com.tencent.mm.plugin.finder.publish.c.class)).finderPostManager().b(((com.tencent.mm.plugin.finder.gallery.c)localObject).BuC);
      }
      com.tencent.mm.plugin.finder.gallery.f localf = com.tencent.mm.plugin.finder.gallery.f.BuT;
      localObject = (k)kotlin.a.p.ae((List)((com.tencent.mm.plugin.finder.gallery.c)localObject).Buy, ((com.tencent.mm.plugin.finder.gallery.c)localObject).BsX.getCurrentItem());
      if (localObject != null) {
        break label175;
      }
      i = 0;
    }
    for (;;)
    {
      localObject = new fh();
      ((fh)localObject).pO(com.tencent.mm.plugin.finder.gallery.f.sessionId);
      ((fh)localObject).iGT = com.tencent.mm.plugin.finder.gallery.f.BuU;
      ((fh)localObject).iFe = 3L;
      ((fh)localObject).pP(com.tencent.mm.plugin.finder.gallery.f.Ov(i));
      ((fh)localObject).iGV = com.tencent.mm.plugin.finder.gallery.f.Ou(i);
      ((fh)localObject).pQ("");
      ((fh)localObject).pR(String.valueOf(com.tencent.mm.model.cn.bDw()));
      ((fh)localObject).bMH();
      com.tencent.mm.plugin.finder.gallery.f.a((com.tencent.mm.plugin.report.a)localObject);
      super.onDestroy();
      AppMethodBeat.o(365728);
      return;
      kotlin.g.b.s.bIx("galleryCore");
      localObject = null;
      break;
      label175:
      localObject = ((k)localObject).Bvc;
      if (localObject == null) {
        i = 0;
      } else {
        i = ((j)localObject).idY;
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderGalleryUI
 * JD-Core Version:    0.7.0.1
 */