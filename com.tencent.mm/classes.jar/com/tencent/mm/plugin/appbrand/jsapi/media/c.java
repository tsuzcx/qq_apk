package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.tencent.luggage.l.e;
import com.tencent.luggage.l.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.a;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.ah.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaWorkFlow;", "", "mComponent", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "mSourceType", "", "mCapture", "mMediaType", "mShowRawButton", "", "maxDuration", "maxCount", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;IIIZII)V", "mMaxCount", "mMaxDuration", "batchRequestPermission", "Lcom/tencent/mm/wx/WxPipeline;", "permissions", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "goAlbumUI", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult;", "goSightCaptureUI", "startChoose", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c.a sfe;
  private final com.tencent.mm.plugin.appbrand.jsapi.f eqB;
  private final int sff;
  private final int sfg;
  private final int sfh;
  private final boolean sfi;
  private final int sfj;
  private final int sfk;
  
  static
  {
    AppMethodBeat.i(50542);
    sfe = new c.a((byte)0);
    AppMethodBeat.o(50542);
  }
  
  public c(com.tencent.mm.plugin.appbrand.jsapi.f paramf, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    AppMethodBeat.i(50541);
    this.eqB = paramf;
    this.sff = paramInt1;
    this.sfg = paramInt2;
    this.sfh = paramInt3;
    this.sfi = paramBoolean;
    this.sfj = Math.min(Math.max(paramInt4, 1), 60);
    this.sfk = Math.min(Math.max(1, 1), 9);
    AppMethodBeat.o(50541);
  }
  
  private final com.tencent.mm.cp.f<Boolean> H(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(329295);
    paramArrayList = com.tencent.mm.cp.g.jPX().b(new c..ExternalSyntheticLambda12(paramArrayList, this));
    s.s(paramArrayList, "pipelineExt()\n          …`$ui` false\n            }");
    AppMethodBeat.o(329295);
    return paramArrayList;
  }
  
  private static final b a(c paramc, SightParams paramSightParams)
  {
    AppMethodBeat.i(329343);
    s.u(paramc, "this$0");
    com.tencent.mm.vending.g.b localb = com.tencent.mm.vending.g.g.jJV();
    Intent localIntent = new Intent();
    localIntent.setClassName(paramc.eqB.getContext(), "com.tencent.mm.plugin.mmsight.ui.SightCaptureUI");
    localIntent.putExtra("KEY_SIGHT_PARAMS", (Parcelable)paramSightParams);
    paramc = AndroidContextUtil.castActivityOrNull(paramc.eqB.getContext());
    if (paramc == null)
    {
      Log.e("MicroMsg.AppBrand.ChooseMediaWorkFlow", "step:goSightCaptureUI context !is activity");
      paramc = new b.c("fail:internal error invalid android context");
      localb.K(new Object[] { paramc });
      paramc = (b)paramc;
      AppMethodBeat.o(329343);
      return paramc;
    }
    e.bt((Context)paramc).a(localIntent, new c..ExternalSyntheticLambda1(localb));
    paramc.overridePendingTransition(ba.a.sight_slide_bottom_in, -1);
    paramc = (b)b.a.sfc;
    AppMethodBeat.o(329343);
    return paramc;
  }
  
  private static final b a(c paramc, Boolean paramBoolean)
  {
    AppMethodBeat.i(329324);
    s.u(paramc, "this$0");
    paramBoolean = com.tencent.mm.vending.g.g.jJV();
    int i = paramc.sfh;
    if (i == r.c.shF.eQp)
    {
      i = 2;
      if (!paramc.sfi) {
        break label244;
      }
    }
    Intent localIntent;
    label244:
    for (int j = 8;; j = 7)
    {
      localIntent = new Intent();
      localIntent.setClassName(paramc.eqB.getContext(), "com.tencent.mm.plugin.gallery.ui.GalleryEntryUI");
      localIntent.putExtra("gallery_report_tag", 16);
      localIntent.putExtra("key_send_raw_image", paramc.sfi);
      localIntent.putExtra("max_select_count", paramc.sfk);
      localIntent.putExtra("query_source_type", j);
      localIntent.putExtra("query_media_type", i);
      localIntent.putExtra("show_header_view", false);
      localIntent.putExtra("album_video_max_duration", 86400);
      localIntent.putExtra("album_business_tag", "album_business_bubble_media_by_jsapi_choosevideo");
      paramc = AndroidContextUtil.castActivityOrNull(paramc.eqB.getContext());
      if (paramc != null) {
        break label250;
      }
      Log.e("MicroMsg.AppBrand.ChooseMediaWorkFlow", "step:goAlbumUI context !is activity");
      paramc = new b.c("fail:internal error invalid android context");
      paramBoolean.K(new Object[] { paramc });
      paramc = (b)paramc;
      AppMethodBeat.o(329324);
      return paramc;
      if (i == r.c.shE.eQp)
      {
        i = 1;
        break;
      }
      i = 3;
      break;
    }
    label250:
    e.bt((Context)paramc).a(localIntent, new c..ExternalSyntheticLambda2(paramBoolean));
    paramc = (b)b.a.sfc;
    AppMethodBeat.o(329324);
    return paramc;
  }
  
  private static final b a(c paramc, Void paramVoid)
  {
    AppMethodBeat.i(329310);
    s.u(paramc, "this$0");
    Object localObject = AndroidContextUtil.castActivityOrNull(paramc.eqB.getContext());
    if (localObject == null)
    {
      Log.e("MicroMsg.AppBrand.ChooseMediaWorkFlow", "step:startActivityForResult, context !is Activity");
      com.tencent.mm.vending.g.g.jJL().gM(new IllegalStateException("fail:internal error invalid android context"));
      paramc = (b)b.a.sfc;
      AppMethodBeat.o(329310);
      return paramc;
    }
    if (r.b.a.a(r.d.shJ, paramc.sff)) {
      com.tencent.mm.vending.g.g.a((d)paramc.ctg());
    }
    for (;;)
    {
      paramc = (b)b.a.sfc;
      AppMethodBeat.o(329310);
      return paramc;
      if (r.b.a.a(r.d.shI, paramc.sff))
      {
        com.tencent.mm.vending.g.g.a((d)paramc.ctf());
      }
      else
      {
        paramVoid = com.tencent.mm.vending.g.g.jJV();
        localObject = new l((Context)localObject);
        ((l)localObject).a(new c..ExternalSyntheticLambda5(paramVoid));
        ((l)localObject).a(null, new c..ExternalSyntheticLambda0(paramc), new c..ExternalSyntheticLambda4(paramc, paramVoid), new c..ExternalSyntheticLambda6(paramVoid));
      }
    }
  }
  
  private static final SightParams a(c paramc, ah.a parama, Boolean paramBoolean)
  {
    AppMethodBeat.i(329333);
    s.u(paramc, "this$0");
    s.u(parama, "$hasExternalStoragePermission");
    int i = paramc.sfh;
    if (i == r.c.shF.eQp) {
      i = 1;
    }
    for (;;)
    {
      paramBoolean = GetSightParamsIPCTask.sfl;
      paramc = GetSightParamsIPCTask.a.q(i, paramc.sfj, r.b.a.a(r.a.shy, paramc.sfg));
      paramc.KUc = false;
      paramc.KUd = true;
      if (!parama.aiwY)
      {
        parama = com.tencent.mm.loader.i.b.bmx();
        if (!y.ZC(parama)) {
          y.bDX(parama);
        }
        paramc.KTV = (com.tencent.mm.loader.i.b.bmx() + paramc.KTX + ".mp4");
      }
      AppMethodBeat.o(329333);
      return paramc;
      if (i == r.c.shE.eQp) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  private static final Boolean a(ArrayList paramArrayList, c paramc, Void paramVoid)
  {
    AppMethodBeat.i(329348);
    s.u(paramArrayList, "$permissions");
    s.u(paramc, "this$0");
    paramVoid = paramArrayList.iterator();
    while (paramVoid.hasNext()) {
      if (i.a(paramc.eqB.getContext(), paramc.eqB, (String)paramVoid.next())) {
        paramVoid.remove();
      }
    }
    if (paramArrayList.isEmpty())
    {
      paramArrayList = Boolean.TRUE;
      AppMethodBeat.o(329348);
      return paramArrayList;
    }
    Object localObject = AndroidContextUtil.castActivityOrNull(paramc.eqB.getContext());
    if (localObject == null)
    {
      Log.e("MicroMsg.AppBrand.ChooseMediaWorkFlow", "step:requestPermission, context !is Activity");
      com.tencent.mm.vending.g.g.jJL().gM(new IllegalStateException("fail:internal error invalid android context"));
      paramArrayList = Boolean.FALSE;
      AppMethodBeat.o(329348);
      return paramArrayList;
    }
    paramVoid = com.tencent.mm.vending.g.g.jJL();
    paramVoid.jJK();
    localObject = e.bt((Context)localObject);
    paramc = paramc.eqB;
    Object[] arrayOfObject = ((Collection)paramArrayList).toArray(new String[0]);
    if (arrayOfObject == null)
    {
      paramArrayList = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(329348);
      throw paramArrayList;
    }
    ((e)localObject).a(paramc, (String[])arrayOfObject, new c..ExternalSyntheticLambda3(paramVoid, paramArrayList));
    paramArrayList = Boolean.FALSE;
    AppMethodBeat.o(329348);
    return paramArrayList;
  }
  
  private static final Boolean a(ah.a parama, c paramc, Void paramVoid)
  {
    AppMethodBeat.i(329330);
    s.u(parama, "$hasExternalStoragePermission");
    s.u(paramc, "this$0");
    parama.aiwY = i.a(paramc.eqB.getContext(), paramc.eqB, "android.permission.WRITE_EXTERNAL_STORAGE");
    Log.i("MicroMsg.AppBrand.ChooseMediaWorkFlow", s.X("has external storage permission: ", Boolean.valueOf(parama.aiwY)));
    parama = new ArrayList();
    parama.add("android.permission.RECORD_AUDIO");
    parama.add("android.permission.CAMERA");
    paramVoid = ah.aiuX;
    com.tencent.mm.vending.g.g.a((d)paramc.H(parama));
    parama = Boolean.FALSE;
    AppMethodBeat.o(329330);
    return parama;
  }
  
  private static final void a(c paramc, ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(329298);
    s.u(paramc, "this$0");
    paramContextMenu.add(0, 1, 0, (CharSequence)paramc.eqB.getContext().getString(ba.i.app_field_mmsight));
    paramContextMenu.add(0, 2, 1, (CharSequence)paramc.eqB.getContext().getString(ba.i.app_field_select_new_pic));
    AppMethodBeat.o(329298);
  }
  
  private static final void a(c paramc, com.tencent.mm.vending.g.b paramb, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(329304);
    s.u(paramc, "this$0");
    switch (paramMenuItem.getItemId())
    {
    default: 
      paramc = com.tencent.mm.cp.g.ha(b.a.sfc);
    }
    for (;;)
    {
      paramc.b(new c..ExternalSyntheticLambda13((kotlin.g.a.b)new b(paramb))).a(new c..ExternalSyntheticLambda15(paramb));
      AppMethodBeat.o(329304);
      return;
      paramc = paramc.ctg();
      continue;
      paramc = paramc.ctf();
    }
  }
  
  private static final void a(com.tencent.mm.vending.g.b paramb, int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(329317);
    if ((paramIntent == null) || (paramInt == 0))
    {
      paramb.K(new Object[] { b.a.sfc });
      AppMethodBeat.o(329317);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    List localList = (List)paramIntent.getStringArrayListExtra("key_select_video_list");
    Object localObject = localList;
    if (localList == null) {
      localObject = (List)ab.aivy;
    }
    localArrayList.addAll((Collection)localObject);
    localObject = (List)paramIntent.getStringArrayListExtra("CropImage_OutputPath_List");
    paramIntent = (Intent)localObject;
    if (localObject == null) {
      paramIntent = (List)ab.aivy;
    }
    localArrayList.addAll((Collection)paramIntent);
    paramIntent = new ArrayList();
    localObject = ((Iterable)localArrayList).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramIntent.add(new com.tencent.mm.vfs.u((String)((Iterator)localObject).next()));
    }
    localObject = ah.aiuX;
    paramb.K(new Object[] { new b.d((List)paramIntent, 1) });
    AppMethodBeat.o(329317);
  }
  
  private static final void a(com.tencent.mm.vending.g.b paramb, ArrayList paramArrayList, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(329345);
    s.u(paramArrayList, "$permissions");
    s.s(paramArrayOfInt, "grantResults");
    int k = paramArrayOfInt.length;
    int j = 0;
    int i = 0;
    while (j < k)
    {
      if (paramArrayOfInt[j] != 0)
      {
        paramb.gM(new IllegalAccessException("fail:system permission denied"));
        Log.e("MicroMsg.AppBrand.ChooseMediaWorkFlow", "interrupt pipeline, " + (String)paramArrayList.get(i) + " denied by user");
        AppMethodBeat.o(329345);
        return;
      }
      j += 1;
      i += 1;
    }
    paramb.K(new Object[] { Boolean.TRUE });
    AppMethodBeat.o(329345);
  }
  
  private static final Boolean b(c paramc, Void paramVoid)
  {
    AppMethodBeat.i(329313);
    s.u(paramc, "this$0");
    paramVoid = new ArrayList();
    paramVoid.add("android.permission.WRITE_EXTERNAL_STORAGE");
    ah localah = ah.aiuX;
    com.tencent.mm.vending.g.g.a((d)paramc.H(paramVoid));
    paramc = Boolean.FALSE;
    AppMethodBeat.o(329313);
    return paramc;
  }
  
  private static final void b(com.tencent.mm.vending.g.b paramb)
  {
    AppMethodBeat.i(329297);
    paramb.K(new Object[] { b.a.sfc });
    AppMethodBeat.o(329297);
  }
  
  private static final void b(com.tencent.mm.vending.g.b paramb, int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(329337);
    if ((paramIntent == null) || (paramInt == 0))
    {
      paramb.K(new Object[] { b.a.sfc });
      AppMethodBeat.o(329337);
      return;
    }
    paramIntent = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
    if (paramIntent == null)
    {
      paramb.K(new Object[] { new b.c("get null sight capture result") });
      AppMethodBeat.o(329337);
      return;
    }
    if (paramIntent.KTL) {}
    for (paramIntent = paramIntent.KTT;; paramIntent = paramIntent.KTN)
    {
      paramb.K(new Object[] { new b.d(p.listOf(new com.tencent.mm.vfs.u(paramIntent)), 2) });
      AppMethodBeat.o(329337);
      return;
    }
  }
  
  private static final void c(com.tencent.mm.vending.g.b paramb)
  {
    AppMethodBeat.i(329306);
    paramb.K(new Object[] { b.a.sfc });
    AppMethodBeat.o(329306);
  }
  
  private static final void c(com.tencent.mm.vending.g.b paramb, Object paramObject)
  {
    AppMethodBeat.i(329302);
    paramb.gM(paramObject);
    AppMethodBeat.o(329302);
  }
  
  private final com.tencent.mm.cp.f<b> ctf()
  {
    AppMethodBeat.i(329290);
    com.tencent.mm.cp.f localf = com.tencent.mm.cp.g.jPX().b(new c..ExternalSyntheticLambda10(this)).b(new c..ExternalSyntheticLambda8(this));
    s.s(localf, "pipelineExt().`$ui`<Bool…Result.CANCELED\n        }");
    AppMethodBeat.o(329290);
    return localf;
  }
  
  private final com.tencent.mm.cp.f<b> ctg()
  {
    AppMethodBeat.i(329293);
    if (Util.getAvailableMemoryMB(this.eqB.getContext()) > 200L) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        Toast.makeText(this.eqB.getContext(), (CharSequence)this.eqB.getContext().getString(ba.i.app_brand_choose_media_memory_check_message), 1).show();
      }
      Object localObject = new ah.a();
      ((ah.a)localObject).aiwY = true;
      localObject = com.tencent.mm.cp.g.jPX().b(new c..ExternalSyntheticLambda14((ah.a)localObject, this)).j(new c..ExternalSyntheticLambda11(this, (ah.a)localObject)).b(new c..ExternalSyntheticLambda7(this));
      s.s(localObject, "pipelineExt()\n          …Result.CANCELED\n        }");
      AppMethodBeat.o(329293);
      return localObject;
    }
  }
  
  private static final ah d(kotlin.g.a.b paramb, Object paramObject)
  {
    AppMethodBeat.i(329300);
    s.u(paramb, "$tmp0");
    paramb = (ah)paramb.invoke(paramObject);
    AppMethodBeat.o(329300);
    return paramb;
  }
  
  public final com.tencent.mm.cp.f<b> cte()
  {
    AppMethodBeat.i(329379);
    com.tencent.mm.cp.f localf = com.tencent.mm.cp.g.jPX().b(new c..ExternalSyntheticLambda9(this));
    s.s(localf, "pipelineExt()\n          …ANCELED\n                }");
    AppMethodBeat.o(329379);
    return localf;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.b<b, ah>
  {
    b(com.tencent.mm.vending.g.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.c
 * JD-Core Version:    0.7.0.1
 */