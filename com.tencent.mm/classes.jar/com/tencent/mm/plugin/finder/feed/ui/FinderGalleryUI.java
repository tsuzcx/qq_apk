package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.dx;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.i;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.gallery.b.a;
import com.tencent.mm.plugin.finder.gallery.c;
import com.tencent.mm.plugin.finder.gallery.f;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.view.FinderViewPager;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.findersdk.a.ae;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderGalleryUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "MENU_POST", "", "MENU_SEARCH_ID", "TAG", "", "galleryConfig", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig;", "getGalleryConfig", "()Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig;", "setGalleryConfig", "(Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig;)V", "galleryCore", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryCore;", "getGalleryCore", "()Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryCore;", "setGalleryCore", "(Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryCore;)V", "checkPermission", "", "checkShowPostBtn", "", "getLayoutId", "hasExtStatusFlag", "flag", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-finder_release"})
public final class FinderGalleryUI
  extends MMFinderUI
{
  private final String TAG = "Finder.FinderGalleryUI";
  private HashMap _$_findViewCache;
  public com.tencent.mm.plugin.finder.gallery.b xNB;
  public c xNK;
  private final int xNL = 1;
  private final int xNM = 2;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(280663);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(280663);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(280661);
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
    AppMethodBeat.o(280661);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_gallery_common_ui;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(280659);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.plugin.finder.gallery.b localb = this.xNB;
    if (localb == null) {
      p.bGy("galleryConfig");
    }
    localb.a((MMActivity)this, paramInt1, paramInt2, paramIntent, com.tencent.mm.plugin.finder.gallery.b.b.xTz);
    AppMethodBeat.o(280659);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    int k = 0;
    AppMethodBeat.i(280658);
    super.onCreate(paramBundle);
    hideActionbarLine();
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    Object localObject = getIntent().getStringExtra("TITLE");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    Log.i(this.TAG, "onCreate, title:".concat(String.valueOf(paramBundle)));
    int i;
    label95:
    boolean bool3;
    label313:
    boolean bool2;
    label320:
    boolean bool1;
    label456:
    int j;
    if (((CharSequence)paramBundle).length() == 0)
    {
      i = 1;
      if (i == 0) {
        break label502;
      }
      setMMTitle(b.j.finder_title);
      paramBundle = (ViewGroup)findViewById(b.f.gallery_core_root);
      localObject = com.tencent.mm.plugin.finder.gallery.b.xTy;
      localObject = getIntent();
      p.j(localObject, "intent");
      this.xNB = b.a.aj((Intent)localObject);
      localObject = (MMActivity)this;
      p.j(paramBundle, "coreRoot");
      com.tencent.mm.plugin.finder.gallery.b localb = this.xNB;
      if (localb == null) {
        p.bGy("galleryConfig");
      }
      this.xNK = new c((MMActivity)localObject, paramBundle, localb);
      localObject = this.xNB;
      if (localObject == null) {
        p.bGy("galleryConfig");
      }
      if (((com.tencent.mm.plugin.finder.gallery.b)localObject).dwb())
      {
        setActionbarColor(getResources().getColor(com.tencent.mm.plugin.gallery.b.b.Dark_5));
        paramBundle.setBackgroundColor(getResources().getColor(com.tencent.mm.plugin.gallery.b.b.Dark_5));
      }
      addIconOptionMenu(this.xNL, -1, b.i.icons_outlined_search, (MenuItem.OnMenuItemClickListener)new c(this));
      paramBundle = this.xNB;
      if (paramBundle == null) {
        p.bGy("galleryConfig");
      }
      if (paramBundle.xTx.xTu.contains(Integer.valueOf(5)))
      {
        bool3 = ((ak)h.ag(ak.class)).showFinderEntry();
        if ((z.bde() & 0x0) == 0L) {
          break label510;
        }
        i = 1;
        if (i != 0) {
          break label515;
        }
        bool2 = true;
        paramBundle = com.tencent.mm.plugin.finder.utils.aj.AGc;
        i = com.tencent.mm.plugin.finder.utils.aj.eei();
        paramBundle = h.ae(ae.class);
        p.j(paramBundle, "MMKernel.service(IFinder…enModeConfig::class.java)");
        bool1 = ((ae)paramBundle).dYT();
        Log.i(this.TAG, "checkPermission show:" + bool3 + ", open:" + bool2 + ", state:" + i + ", teenMode:" + bool1);
        paramBundle = com.tencent.mm.plugin.finder.storage.d.AjH;
        switch (((Number)com.tencent.mm.plugin.finder.storage.d.dTZ().aSr()).intValue())
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
        addIconOptionMenu(this.xNM, -1, b.i.icons_outlined_camera, (MenuItem.OnMenuItemClickListener)new a(this));
      }
      AppMethodBeat.o(280658);
      return;
      i = 0;
      break;
      label502:
      setMMTitle(paramBundle);
      break label95;
      label510:
      i = 0;
      break label313;
      label515:
      bool2 = false;
      break label320;
      bool3 = false;
      break label456;
      i = 1;
      break label456;
      bool2 = false;
      break label456;
      bool1 = true;
      break label456;
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
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(280660);
    Object localObject = this.xNK;
    if (localObject == null) {
      p.bGy("galleryCore");
    }
    f localf = f.xUa;
    localObject = (com.tencent.mm.plugin.finder.gallery.k)kotlin.a.j.M((List)((c)localObject).xTC, ((c)localObject).xTD.getCurrentItem());
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.gallery.k)localObject).xUh;
      if (localObject == null) {}
    }
    for (int i = ((com.tencent.mm.plugin.finder.gallery.j)localObject).fXY;; i = 0)
    {
      localObject = new dx();
      ((dx)localObject).qZ(f.sessionId);
      ((dx)localObject).kd(f.xTY);
      ((dx)localObject).ke(3L);
      ((dx)localObject).ra(f.MS(i));
      ((dx)localObject).kf(f.MR(i));
      ((dx)localObject).rb("");
      ((dx)localObject).rc(String.valueOf(cm.bfE()));
      ((dx)localObject).bpa();
      f.a((com.tencent.mm.plugin.report.a)localObject);
      super.onDestroy();
      AppMethodBeat.o(280660);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderGalleryUI paramFinderGalleryUI) {}
    
    public final boolean onMenuItemClick(final MenuItem paramMenuItem)
    {
      AppMethodBeat.i(290123);
      paramMenuItem = this.xNN.getContext();
      Object localObject1 = new StringBuilder();
      p.j(h.aHE(), "MMKernel.account()");
      localObject1 = com.tencent.mm.kernel.b.aGq() + '_' + Util.nowMilliSecond();
      com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e((Context)paramMenuItem, 1, true);
      Object localObject2 = com.tencent.mm.plugin.finder.utils.aj.AGc;
      if (com.tencent.mm.plugin.finder.utils.aj.edY())
      {
        localObject2 = ad.kS((Context)paramMenuItem).inflate(b.g.finder_sheet_header, null);
        Object localObject4 = (TextView)((View)localObject2).findViewById(b.f.nickname);
        ImageView localImageView = (ImageView)((View)localObject2).findViewById(b.f.avatar);
        Object localObject3 = com.tencent.mm.plugin.finder.api.d.wZQ;
        localObject3 = d.a.aAK(z.bdh());
        if (localObject3 != null)
        {
          p.j(localObject4, "nicknameTv");
          ((TextView)localObject4).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)paramMenuItem, (CharSequence)((i)localObject3).getNickname()));
          localObject4 = t.ztT;
          localObject4 = t.dJh();
          localObject3 = new com.tencent.mm.plugin.finder.loader.e(((i)localObject3).field_avatarUrl);
          p.j(localImageView, "avatarIv");
          t localt = t.ztT;
          ((com.tencent.mm.loader.d)localObject4).a(localObject3, localImageView, t.a(t.a.ztX));
        }
        locale.Z((View)localObject2, true);
      }
      localObject2 = com.tencent.mm.plugin.finder.report.k.zWs;
      com.tencent.mm.plugin.finder.report.k.aEa((String)localObject1);
      locale.a((q.f)new q.f()
      {
        public final void onCreateMMMenu(o paramAnonymouso)
        {
          Object localObject = null;
          AppMethodBeat.i(282868);
          p.j(paramAnonymouso, "it");
          if (paramAnonymouso.hJO())
          {
            paramAnonymouso.mn(1001, b.j.app_field_mmsight);
            paramAnonymouso.mn(1002, b.j.app_field_select_new_pic);
          }
          paramAnonymouso = n.zWF;
          paramAnonymouso = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
          paramAnonymouso = this.xNO.xNN.getContext();
          p.j(paramAnonymouso, "context");
          paramAnonymouso = aj.a.fZ((Context)paramAnonymouso);
          if (paramAnonymouso != null) {}
          for (paramAnonymouso = paramAnonymouso.ekY();; paramAnonymouso = null)
          {
            n.b(0, "post_acionsheet_camera", "", paramAnonymouso);
            paramAnonymouso = n.zWF;
            paramAnonymouso = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
            paramAnonymouso = this.xNO.xNN.getContext();
            p.j(paramAnonymouso, "context");
            com.tencent.mm.plugin.finder.viewmodel.component.aj localaj = aj.a.fZ((Context)paramAnonymouso);
            paramAnonymouso = localObject;
            if (localaj != null) {
              paramAnonymouso = localaj.ekY();
            }
            n.b(0, "post_actionsheet_album", "", paramAnonymouso);
            AppMethodBeat.o(282868);
            return;
          }
        }
      });
      locale.a((q.g)new q.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          Object localObject = null;
          AppMethodBeat.i(274294);
          Intent localIntent = new Intent();
          p.j(paramAnonymousMenuItem, "menuItem");
          if (paramAnonymousMenuItem.getItemId() == 1001)
          {
            localIntent.putExtra("key_finder_post_router", 2);
            paramAnonymousMenuItem = n.zWF;
            paramAnonymousMenuItem = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
            paramAnonymousMenuItem = this.xNO.xNN.getContext();
            p.j(paramAnonymousMenuItem, "context");
            paramAnonymousMenuItem = aj.a.fZ((Context)paramAnonymousMenuItem);
            if (paramAnonymousMenuItem != null)
            {
              paramAnonymousMenuItem = paramAnonymousMenuItem.ekY();
              n.b(1, "post_acionsheet_camera", "", paramAnonymousMenuItem);
            }
          }
          for (;;)
          {
            localIntent.putExtra("key_finder_post_from", 12);
            localIntent.putExtra("key_finder_post_id", this.xNP);
            paramAnonymousMenuItem = com.tencent.mm.plugin.finder.utils.a.ACH;
            paramAnonymousMenuItem = paramMenuItem;
            p.j(paramAnonymousMenuItem, "activity");
            com.tencent.mm.plugin.finder.utils.a.enterFinderPostRouterUI((Context)paramAnonymousMenuItem, localIntent);
            paramAnonymousMenuItem = com.tencent.mm.plugin.finder.report.k.zWs;
            com.tencent.mm.plugin.finder.report.k.av(14, false);
            AppMethodBeat.o(274294);
            return;
            paramAnonymousMenuItem = null;
            break;
            if (paramAnonymousMenuItem.getItemId() == 1002)
            {
              localIntent.putExtra("key_finder_post_router", 3);
              paramAnonymousMenuItem = n.zWF;
              paramAnonymousMenuItem = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
              paramAnonymousMenuItem = this.xNO.xNN.getContext();
              p.j(paramAnonymousMenuItem, "context");
              com.tencent.mm.plugin.finder.viewmodel.component.aj localaj = aj.a.fZ((Context)paramAnonymousMenuItem);
              paramAnonymousMenuItem = localObject;
              if (localaj != null) {
                paramAnonymousMenuItem = localaj.ekY();
              }
              n.b(1, "post_actionsheet_album", "", paramAnonymousMenuItem);
            }
          }
        }
      });
      locale.b((e.b)3.xNQ);
      locale.eik();
      AppMethodBeat.o(290123);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderGalleryUI paramFinderGalleryUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(286192);
      this.xNN.finish();
      AppMethodBeat.o(286192);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(FinderGalleryUI paramFinderGalleryUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(274989);
      paramMenuItem = new Intent(this.xNN.getIntent());
      com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.ACH;
      com.tencent.mm.plugin.finder.utils.a.Z((Context)this.xNN, paramMenuItem);
      paramMenuItem = f.xUa;
      paramMenuItem = new dx();
      paramMenuItem.qZ(f.sessionId);
      paramMenuItem.kd(f.xTY);
      paramMenuItem.ke(2L);
      paramMenuItem.ra("search_icon");
      paramMenuItem.kf(0L);
      paramMenuItem.rb("");
      paramMenuItem.rc(String.valueOf(cm.bfE()));
      paramMenuItem.bpa();
      f.a((com.tencent.mm.plugin.report.a)paramMenuItem);
      AppMethodBeat.o(274989);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderGalleryUI
 * JD-Core Version:    0.7.0.1
 */