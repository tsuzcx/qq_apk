package com.tencent.mm.plugin.emoji.ui.v3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.b;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.emoji.h.a;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.emoji.h.c;
import com.tencent.mm.plugin.emoji.h.e;
import com.tencent.mm.plugin.emoji.h.f;
import com.tencent.mm.plugin.emoji.h.g;
import com.tencent.mm.plugin.emoji.h.h;
import com.tencent.mm.plugin.emoji.mgr.f;
import com.tencent.mm.plugin.emoji.mgr.j;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.ui.v3.a.ab;
import com.tencent.mm.plugin.emoji.ui.v3.a.ac;
import com.tencent.mm.plugin.emoji.ui.v3.a.e;
import com.tencent.mm.plugin.emoji.ui.v3.a.k;
import com.tencent.mm.plugin.emoji.ui.v3.a.o;
import com.tencent.mm.plugin.emoji.ui.v3.a.t;
import com.tencent.mm.plugin.emoji.ui.v3.a.y;
import com.tencent.mm.plugin.emoji.ui.v3.b.d;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.cii;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/v3/EmojiStoreV3SingleProductAlbumUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "REQUEST_CODE_SELECT_CONTACT_SHARED", "", "getREQUEST_CODE_SELECT_CONTACT_SHARED", "()I", "TAG", "", "albumDesc", "albumIconUrl", "albumName", "albumSecondUrl", "enterSingleProductDialog", "", "entranceScene", "firstExposeReport", "loadFirstPage", "loadingView", "Landroid/view/View;", "needReExposeReport", "netQuestStatus", "Lcom/tencent/mm/plugin/emoji/ui/v3/EmojiStoreV3SingleProductAlbumUI$NetQuestStatus;", "pageBuf", "", "rv", "Lcom/tencent/mm/plugin/emoji/ui/v3/EmojiStoreV3SingleProductRecyclerView;", "rvAdapter", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3SingleProductAdapter;", "setId", "sharePageType", "snsObjectData", "getForceOrientation", "getLayoutId", "handleIntent", "", "handleRemoteEmojiListData", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "hideBottomLoadingUI", "initData", "initLoadingView", "initRecyclerView", "initTitlebar", "initViews", "loadCache", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onSceneEnd", "report12740", "requestNextPageRemoteData", "requestRemoteData", "showBottomLoadingUI", "showContentUIState", "showError", "showLoadingUIState", "showSingleProductAlbumInfoHeader", "updateAdapterData", "emojiInfoList", "", "Lcom/tencent/mm/protocal/protobuf/EmojiInfo;", "append", "NetQuestStatus", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class EmojiStoreV3SingleProductAlbumUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private final String TAG = "MicroMsg.EmojiStoreV3SingleProductAlbumUI";
  private String albumName = "";
  private View njN;
  private int xYX = -1;
  private int yaA = -1;
  private byte[] yaB;
  private EmojiStoreV3SingleProductAlbumUI.a yaC = EmojiStoreV3SingleProductAlbumUI.a.yaI;
  private boolean yaD = true;
  private final boolean yaE = true;
  private boolean yaF = true;
  private boolean yaG;
  private final int yaH = 2002;
  private EmojiStoreV3SingleProductRecyclerView yas;
  private o yat;
  private String yau = "";
  private String yav = "";
  private String yax = "";
  private int yay = 6;
  private String yaz = "";
  
  private static final void a(EmojiStoreV3SingleProductAlbumUI paramEmojiStoreV3SingleProductAlbumUI)
  {
    AppMethodBeat.i(270498);
    kotlin.g.b.s.u(paramEmojiStoreV3SingleProductAlbumUI, "this$0");
    paramEmojiStoreV3SingleProductAlbumUI.yaF = false;
    o localo = paramEmojiStoreV3SingleProductAlbumUI.yat;
    if (localo != null)
    {
      paramEmojiStoreV3SingleProductAlbumUI = paramEmojiStoreV3SingleProductAlbumUI.yas;
      if (paramEmojiStoreV3SingleProductAlbumUI != null) {
        break label47;
      }
    }
    label47:
    for (paramEmojiStoreV3SingleProductAlbumUI = null;; paramEmojiStoreV3SingleProductAlbumUI = paramEmojiStoreV3SingleProductAlbumUI.getLayoutManager())
    {
      localo.i(paramEmojiStoreV3SingleProductAlbumUI);
      AppMethodBeat.o(270498);
      return;
    }
  }
  
  private static final boolean a(EmojiStoreV3SingleProductAlbumUI paramEmojiStoreV3SingleProductAlbumUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(270489);
    kotlin.g.b.s.u(paramEmojiStoreV3SingleProductAlbumUI, "this$0");
    paramEmojiStoreV3SingleProductAlbumUI.finish();
    AppMethodBeat.o(270489);
    return false;
  }
  
  private static final void b(EmojiStoreV3SingleProductAlbumUI paramEmojiStoreV3SingleProductAlbumUI)
  {
    AppMethodBeat.i(270506);
    kotlin.g.b.s.u(paramEmojiStoreV3SingleProductAlbumUI, "this$0");
    paramEmojiStoreV3SingleProductAlbumUI = paramEmojiStoreV3SingleProductAlbumUI.yat;
    if (paramEmojiStoreV3SingleProductAlbumUI != null) {
      if (((Collection)paramEmojiStoreV3SingleProductAlbumUI.ycw).isEmpty()) {
        break label91;
      }
    }
    label91:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (((t)kotlin.a.p.oM(paramEmojiStoreV3SingleProductAlbumUI.ycw)).getType() != 8))
      {
        paramEmojiStoreV3SingleProductAlbumUI.ycw.add(paramEmojiStoreV3SingleProductAlbumUI.ycB);
        paramEmojiStoreV3SingleProductAlbumUI.fV(paramEmojiStoreV3SingleProductAlbumUI.getItemCount() - 1);
      }
      AppMethodBeat.o(270506);
      return;
    }
  }
  
  private static final boolean b(EmojiStoreV3SingleProductAlbumUI paramEmojiStoreV3SingleProductAlbumUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(270494);
    kotlin.g.b.s.u(paramEmojiStoreV3SingleProductAlbumUI, "this$0");
    paramMenuItem = com.tencent.mm.plugin.emoji.g.a.ydF;
    com.tencent.mm.plugin.emoji.g.a.a((Activity)paramEmojiStoreV3SingleProductAlbumUI, paramEmojiStoreV3SingleProductAlbumUI.yaA, paramEmojiStoreV3SingleProductAlbumUI.albumName, paramEmojiStoreV3SingleProductAlbumUI.yau, paramEmojiStoreV3SingleProductAlbumUI.yav, paramEmojiStoreV3SingleProductAlbumUI.yax, paramEmojiStoreV3SingleProductAlbumUI.yay, paramEmojiStoreV3SingleProductAlbumUI.yaH);
    AppMethodBeat.o(270494);
    return false;
  }
  
  private final void c(int paramInt1, int paramInt2, com.tencent.mm.am.p paramp)
  {
    Object localObject3 = null;
    AppMethodBeat.i(270466);
    Object localObject1 = this.yat;
    int i;
    Object localObject2;
    if ((localObject1 != null) && (((o)localObject1).getItemCount() == 0))
    {
      i = 1;
      if ((i != 0) && (!kotlin.g.b.s.p(this.albumName, "")))
      {
        localObject1 = new y();
        localObject2 = this.yau;
        kotlin.g.b.s.u(localObject2, "<set-?>");
        ((y)localObject1).yau = ((String)localObject2);
        localObject2 = this.albumName;
        kotlin.g.b.s.u(localObject2, "<set-?>");
        ((y)localObject1).albumName = ((String)localObject2);
        localObject2 = this.yat;
        if (localObject2 != null)
        {
          localObject2 = ((o)localObject2).ycw;
          if (localObject2 != null) {
            ((List)localObject2).add(0, localObject1);
          }
        }
        localObject1 = this.yat;
        if (localObject1 != null) {
          ((o)localObject1).fV(0);
        }
      }
      if (!(paramp instanceof com.tencent.mm.plugin.emoji.e.i)) {
        break label392;
      }
      paramp = (com.tencent.mm.plugin.emoji.e.i)paramp;
      label161:
      if (paramp != null) {
        break label397;
      }
      localObject1 = null;
      label168:
      if (localObject1 != null) {
        break label406;
      }
      localObject1 = null;
      label176:
      localObject2 = this.yat;
      if (localObject2 != null)
      {
        if (((Collection)((o)localObject2).ycw).isEmpty()) {
          break label416;
        }
        i = 1;
        label206:
        if ((i != 0) && (((t)kotlin.a.p.oM(((o)localObject2).ycw)).getType() == 8))
        {
          ((o)localObject2).t(((o)localObject2).getItemCount() - 1, Boolean.TRUE);
          ((o)localObject2).fX(((o)localObject2).getItemCount() - 1);
          ((o)localObject2).ycw.remove(((o)localObject2).getItemCount() - 1);
          Log.d(((o)localObject2).TAG, "removeBottomLoadingUI");
        }
      }
      setBounceEnabled(true);
      switch (paramInt1)
      {
      default: 
        dCu();
        label324:
        if (paramp != null) {
          break;
        }
      }
    }
    for (paramp = localObject3;; paramp = paramp.xOw)
    {
      this.yaB = paramp;
      if (this.yaE) {
        com.tencent.threadpool.h.ahAA.o(new EmojiStoreV3SingleProductAlbumUI..ExternalSyntheticLambda3(this), 500L);
      }
      if (this.yaD)
      {
        dCQ();
        this.yaD = false;
      }
      AppMethodBeat.o(270466);
      return;
      i = 0;
      break;
      label392:
      paramp = null;
      break label161;
      label397:
      localObject1 = paramp.dAA();
      break label168;
      label406:
      localObject1 = ((cii)localObject1).aaqZ;
      break label176;
      label416:
      i = 0;
      break label206;
      String str = this.TAG;
      if (localObject1 == null) {}
      for (localObject2 = null;; localObject2 = Integer.valueOf(((LinkedList)localObject1).size()))
      {
        Log.d(str, kotlin.g.b.s.X("onSceneEnd data size:", localObject2));
        switch (paramInt2)
        {
        case 1: 
        default: 
          dCu();
          break label324;
        }
      }
      this.yaC = EmojiStoreV3SingleProductAlbumUI.a.yaI;
      h((List)localObject1, true);
      break label324;
      this.yaC = EmojiStoreV3SingleProductAlbumUI.a.yaJ;
      h((List)localObject1, true);
      break label324;
      this.yaC = EmojiStoreV3SingleProductAlbumUI.a.yaI;
      h((List)localObject1, false);
      break label324;
    }
  }
  
  private final void dCQ()
  {
    AppMethodBeat.i(270450);
    if (this.yaC != EmojiStoreV3SingleProductAlbumUI.a.yaJ)
    {
      Log.d(this.TAG, "try to pre load more");
      setBounceEnabled(false);
      EmojiStoreV3SingleProductRecyclerView localEmojiStoreV3SingleProductRecyclerView = this.yas;
      if (localEmojiStoreV3SingleProductRecyclerView != null) {
        localEmojiStoreV3SingleProductRecyclerView.post(new EmojiStoreV3SingleProductAlbumUI..ExternalSyntheticLambda2(this));
      }
      dCR();
    }
    AppMethodBeat.o(270450);
  }
  
  private void dCR()
  {
    AppMethodBeat.i(270454);
    if (EmojiStoreV3SingleProductAlbumUI.a.yaI == this.yaC)
    {
      com.tencent.mm.plugin.emoji.e.i locali = new com.tencent.mm.plugin.emoji.e.i(5, 0, 0, null, this.yaA, this.yaB);
      com.tencent.mm.kernel.h.baD().mCm.a((com.tencent.mm.am.p)locali, 0);
      this.yaC = EmojiStoreV3SingleProductAlbumUI.a.yaK;
    }
    AppMethodBeat.o(270454);
  }
  
  private final void dCu()
  {
    AppMethodBeat.i(270484);
    Toast.makeText((Context)getContext(), (CharSequence)getString(h.h.emoji_unknow), 0).show();
    AppMethodBeat.o(270484);
  }
  
  private void h(List<amn> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(270477);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      Log.i(this.TAG, "updateAdapterData failed, data error");
      AppMethodBeat.o(270477);
      return;
    }
    o localo = this.yat;
    if (localo != null)
    {
      List localList = (List)new ArrayList();
      Object localObject = (Iterable)paramList;
      paramList = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        amn localamn = (amn)((Iterator)localObject).next();
        ac localac = new ac();
        localac.ycT = localamn;
        paramList.add(localac);
      }
      localList.addAll((Collection)paramList);
      if (paramBoolean)
      {
        int i = localo.getItemCount();
        localo.ycw.addAll((Collection)localList);
        localo.by(i, localList.size());
        AppMethodBeat.o(270477);
        return;
      }
      localo.ycw.clear();
      localo.ycw.addAll((Collection)localList);
      localo.bZE.notifyChanged();
    }
    AppMethodBeat.o(270477);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return h.f.emoji_store_v3_single_product_album_ui;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(270592);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1) {
      if (paramInt2 == -1) {
        com.tencent.mm.ui.widget.snackbar.b.u((Activity)this, getContext().getString(h.h.app_sent));
      }
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(270592);
      return;
      Log.i(this.TAG, kotlin.g.b.s.X("onActivityResult failed, START_SINGLE_PRODUCT_DIALOG, resultCode:", Integer.valueOf(paramInt2)));
      continue;
      if (paramInt1 == this.yaH) {
        if (paramInt2 == -1)
        {
          if (paramIntent == null) {}
          for (String str1 = null;; str1 = paramIntent.getStringExtra("Select_Conv_User"))
          {
            if (Util.isNullOrNil(str1)) {
              break label200;
            }
            Log.d(this.TAG, kotlin.g.b.s.X("..", str1));
            MMActivity localMMActivity = (MMActivity)this;
            int i = this.yaA;
            String str2 = this.albumName;
            String str3 = this.yau;
            String str4 = this.yav;
            String str5 = this.yax;
            int j = this.yay;
            com.tencent.mm.plugin.emoji.model.s.dAl();
            j.a(localMMActivity, str1, 27, i, str2, str3, str4, str5, j, f.dzu());
            break;
          }
        }
        else
        {
          label200:
          Log.i(this.TAG, kotlin.g.b.s.X("onActivityResult failed, SELECT_CONTACT_SHARED, resultCode:", Integer.valueOf(paramInt2)));
        }
      }
    }
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(270555);
    super.onCreate(paramBundle);
    Log.d(this.TAG, "onCreate");
    this.yaA = getIntent().getIntExtra("set_id", -1);
    Object localObject = getIntent().getStringExtra("set_title");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    this.albumName = paramBundle;
    localObject = getIntent().getStringExtra("set_desc");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    this.yau = paramBundle;
    localObject = getIntent().getStringExtra("set_iconURL");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    this.yav = paramBundle;
    localObject = getIntent().getStringExtra("headurl");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    this.yax = paramBundle;
    localObject = getIntent().getStringExtra("sns_object_data");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    this.yaz = paramBundle;
    if (!Util.isNullOrNil(this.yaz))
    {
      this.yaA = EmojiLogic.aoB(this.yaz);
      paramBundle = EmojiLogic.aoC(this.yaz);
      kotlin.g.b.s.s(paramBundle, "getEmojiPageTitle(snsObjectData)");
      this.albumName = paramBundle;
      paramBundle = EmojiLogic.aoE(this.yaz);
      kotlin.g.b.s.s(paramBundle, "getEmojiPageIconUrl(snsObjectData)");
      this.yav = paramBundle;
      paramBundle = EmojiLogic.aoD(this.yaz);
      kotlin.g.b.s.s(paramBundle, "getEmojiPageDesc(snsObjectData)");
      this.yau = paramBundle;
      paramBundle = EmojiLogic.aoF(this.yaz);
      kotlin.g.b.s.s(paramBundle, "getEmojiPageSecondUrl(snsObjectData)");
      this.yax = paramBundle;
      this.yay = EmojiLogic.aoG(this.yaz);
    }
    this.xYX = getIntent().getIntExtra("entrance_scene", 10007);
    setMMTitle("");
    setBackBtn(new EmojiStoreV3SingleProductAlbumUI..ExternalSyntheticLambda0(this));
    setActionbarColor(com.tencent.mm.cd.a.w((Context)getContext(), h.b.BW_100));
    if (!kotlin.g.b.s.p(this.yav, "")) {
      addIconOptionMenu(0, h.g.icons_filled_more, new EmojiStoreV3SingleProductAlbumUI..ExternalSyntheticLambda1(this));
    }
    this.njN = findViewById(h.e.loading);
    paramBundle = this.njN;
    if (paramBundle != null) {
      paramBundle.setBackgroundResource(h.b.BW_100);
    }
    this.yas = ((EmojiStoreV3SingleProductRecyclerView)findViewById(h.e.single_product_album_rv));
    localObject = new ab();
    int j = ((k)localObject).spanCount;
    int k = (int)getResources().getDimension(h.c.Edge_2A);
    if (!kotlin.g.b.s.p(this.albumName, "")) {}
    for (int i = 1;; i = 0)
    {
      paramBundle = new a(k, i, (k)localObject);
      EmojiStoreV3SingleProductRecyclerView localEmojiStoreV3SingleProductRecyclerView = this.yas;
      if (localEmojiStoreV3SingleProductRecyclerView != null) {
        localEmojiStoreV3SingleProductRecyclerView.setSizeResolver((k)localObject);
      }
      localObject = this.yas;
      if (localObject != null) {
        ((RecyclerView)localObject).a((RecyclerView.h)paramBundle);
      }
      paramBundle = new GridLayoutManager(j);
      paramBundle.bWq = ((GridLayoutManager.b)new b(this, paramBundle));
      localObject = this.yas;
      if (localObject != null) {
        ((EmojiStoreV3SingleProductRecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)paramBundle);
      }
      this.yat = new o((Context)this, (List)new ArrayList());
      paramBundle = this.yas;
      if (paramBundle != null) {
        paramBundle.setAdapter((RecyclerView.a)this.yat);
      }
      paramBundle = this.yat;
      if (paramBundle != null) {
        paramBundle.ycA = j;
      }
      paramBundle = this.yat;
      if (paramBundle != null) {
        paramBundle.ycy = ((kotlin.g.a.a)new EmojiStoreV3SingleProductAlbumUI.c(this));
      }
      paramBundle = this.yat;
      if (paramBundle != null) {
        paramBundle.ycz = ((kotlin.g.a.b)new EmojiStoreV3SingleProductAlbumUI.d(this));
      }
      paramBundle = this.yat;
      if (paramBundle != null) {
        paramBundle.ycx = ((com.tencent.mm.plugin.emoji.ui.v3.a.u)new e(this));
      }
      paramBundle = this.yat;
      if (paramBundle != null) {
        paramBundle.ybT = ((kotlin.g.a.b)new f(this));
      }
      paramBundle = this.njN;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
      paramBundle = this.yas;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      dCR();
      com.tencent.mm.kernel.h.baD().mCm.a(821, (com.tencent.mm.am.h)this);
      com.tencent.mm.plugin.report.service.h.OAn.b(12740, new Object[] { Integer.valueOf(4), "", "", Integer.valueOf(0), Integer.valueOf(this.xYX), Integer.valueOf(29) });
      AppMethodBeat.o(270555);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(270572);
    super.onDestroy();
    Log.d(this.TAG, "onDestroy");
    com.tencent.mm.kernel.h.baD().mCm.b(821, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(270572);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(270566);
    super.onPause();
    this.yaF = true;
    AppMethodBeat.o(270566);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(270560);
    super.onResume();
    o localo;
    if ((this.yaF) && (!this.yaG))
    {
      this.yaF = false;
      localo = this.yat;
      if (localo != null)
      {
        localObject = this.yas;
        if (localObject != null) {
          break label66;
        }
      }
    }
    label66:
    for (Object localObject = null;; localObject = ((EmojiStoreV3SingleProductRecyclerView)localObject).getLayoutManager())
    {
      localo.i((RecyclerView.LayoutManager)localObject);
      this.yaG = false;
      AppMethodBeat.o(270560);
      return;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(270580);
    paramString = this.njN;
    if (paramString != null) {
      paramString.setVisibility(8);
    }
    paramString = this.yas;
    if (paramString != null) {
      paramString.setVisibility(0);
    }
    if (paramp == null) {}
    for (paramString = null;; paramString = Integer.valueOf(paramp.getType()))
    {
      Log.i(this.TAG, "type:" + paramString + ", errType:" + paramInt1 + ", errCode:" + paramInt2);
      if (paramString != null) {
        break;
      }
      AppMethodBeat.o(270580);
      return;
    }
    if (paramString.intValue() == 821) {
      c(paramInt1, paramInt2, paramp);
    }
    AppMethodBeat.o(270580);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/emoji/ui/v3/EmojiStoreV3SingleProductAlbumUI$initRecyclerView$1", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends GridLayoutManager.b
  {
    b(EmojiStoreV3SingleProductAlbumUI paramEmojiStoreV3SingleProductAlbumUI, GridLayoutManager paramGridLayoutManager) {}
    
    public final int fJ(int paramInt)
    {
      AppMethodBeat.i(270509);
      Object localObject = EmojiStoreV3SingleProductAlbumUI.c(this.yaM);
      if (localObject == null)
      {
        localObject = null;
        if (localObject != null) {
          break label46;
        }
        label23:
        if (localObject != null) {
          break label70;
        }
      }
      label46:
      label70:
      while (((Integer)localObject).intValue() != 8)
      {
        AppMethodBeat.o(270509);
        return 1;
        localObject = Integer.valueOf(((o)localObject).getItemViewType(paramInt));
        break;
        if (((Integer)localObject).intValue() != 7) {
          break label23;
        }
        paramInt = paramBundle.bWl;
        AppMethodBeat.o(270509);
        return paramInt;
      }
      paramInt = paramBundle.bWl;
      AppMethodBeat.o(270509);
      return paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/emoji/ui/v3/EmojiStoreV3SingleProductAlbumUI$initRecyclerView$4", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/IEmojiStoreV3ClickListener;", "onClick", "", "holder", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3BaseHolder;", "position", "", "item", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/IEmojiStoreTypeItem;", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements com.tencent.mm.plugin.emoji.ui.v3.a.u
  {
    e(EmojiStoreV3SingleProductAlbumUI paramEmojiStoreV3SingleProductAlbumUI) {}
    
    public final void a(e<?> parame, int paramInt, t paramt)
    {
      AppMethodBeat.i(270501);
      kotlin.g.b.s.u(parame, "holder");
      if (paramt == null)
      {
        AppMethodBeat.o(270501);
        return;
      }
      if (paramt.getType() == 4)
      {
        if (!(paramt instanceof ac)) {
          break label115;
        }
        parame = (ac)paramt;
        if (parame != null) {
          break label120;
        }
      }
      label115:
      label120:
      for (parame = null;; parame = parame.ycT)
      {
        if (parame != null)
        {
          paramt = com.tencent.mm.plugin.emoji.g.a.ydF;
          paramt = com.tencent.mm.plugin.emoji.g.a.a((Context)this.yaM, parame, "", 0, 56);
          EmojiStoreV3SingleProductAlbumUI.f(this.yaM);
          this.yaM.startActivityForResult(paramt, 1);
          this.yaM.overridePendingTransition(h.a.pop_in, h.a.pop_out);
        }
        com.tencent.mm.plugin.emoji.ui.v3.b.a.a(parame, 29);
        AppMethodBeat.o(270501);
        return;
        parame = null;
        break;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/emoji/ui/v3/report/SingleProductExpose12875Data;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.b<d, ah>
  {
    f(EmojiStoreV3SingleProductAlbumUI paramEmojiStoreV3SingleProductAlbumUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v3.EmojiStoreV3SingleProductAlbumUI
 * JD-Core Version:    0.7.0.1
 */