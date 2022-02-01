package com.tencent.mm.plugin.gallery.a;

import android.content.Intent;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.SnsTemplateReportStruct;
import com.tencent.mm.plugin.comm.b.e;
import com.tencent.mm.plugin.comm.b.e.a;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI;
import com.tencent.mm.plugin.gallery.ui.ImagePreviewUI;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.protocal.protobuf.ffv;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.ai;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/mjtemplate/MJTemplateHandle;", "", "()V", "TAG", "", "albumTemplateUI", "Lcom/tencent/mm/plugin/gallery/mjtemplate/AlbumTemplateUI;", "albumUI", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/gallery/ui/AlbumPreviewUI;", "isOnlySelectVideo", "", "isSelectMultiMedia", "isSelectVideoAndImages", "permissionRequesting", "previewTemplateUI", "Lcom/tencent/mm/plugin/gallery/mjtemplate/PreviewTemplateUI;", "previewUI", "Lcom/tencent/mm/plugin/gallery/ui/ImagePreviewUI;", "reported", "selectMediaTotalDuration", "", "updateAlbumUISelectLimit", "Lkotlin/Function0;", "", "videoTemplateInfo", "Lcom/tencent/mm/protocal/protobuf/SnsVideoTemplate;", "bindAlbumUI", "bindPreviewUI", "checkSelectMediaValid", "item", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "isEditWithOutputTemplate", "isEnable", "jumpToTemplatePage", "context", "Landroid/app/Activity;", "selectMediaList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "videoTemplate", "onMediaClick", "position", "itemView", "Landroid/view/View;", "itemViewType", "onSendItemClick", "mediaList", "onRequestResult", "report", "selectMediaLimit", "unbind", "unbindPreviewUI", "updateSendPhotoCount", "toInstance", "T", "(Ljava/lang/ref/WeakReference;)Ljava/lang/Object;", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static ffv HFI;
  public static final c HFY;
  public static a HFZ;
  public static d HGa;
  public static WeakReference<AlbumPreviewUI> HGb;
  public static WeakReference<ImagePreviewUI> HGc;
  private static boolean HGd;
  public static int HGe;
  private static boolean HGf;
  private static boolean HGg;
  private static final kotlin.g.a.a<ah> HGh;
  private static boolean HGi;
  public static boolean nWh;
  
  static
  {
    AppMethodBeat.i(289318);
    HFY = new c();
    HGh = (kotlin.g.a.a)d.HGm;
    AppMethodBeat.o(289318);
  }
  
  /* Error */
  public static boolean a(ArrayList<GalleryItem.MediaItem> paramArrayList, kotlin.g.a.a<ah> parama)
  {
    // Byte code:
    //   0: ldc 132
    //   2: invokestatic 106	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ldc 133
    //   8: invokestatic 138	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: aload_1
    //   12: ldc 139
    //   14: invokestatic 138	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   17: getstatic 141	com/tencent/mm/plugin/gallery/a/c:HGb	Ljava/lang/ref/WeakReference;
    //   20: astore_3
    //   21: aload_3
    //   22: ifnonnull +243 -> 265
    //   25: aconst_null
    //   26: astore_3
    //   27: getstatic 143	com/tencent/mm/plugin/gallery/a/c:HFZ	Lcom/tencent/mm/plugin/gallery/a/a;
    //   30: astore 4
    //   32: aload 4
    //   34: ifnull +242 -> 276
    //   37: aload 4
    //   39: getfield 148	com/tencent/mm/plugin/gallery/a/a:HFJ	Z
    //   42: iconst_1
    //   43: if_icmpne +233 -> 276
    //   46: iconst_1
    //   47: istore_2
    //   48: iload_2
    //   49: ifeq +432 -> 481
    //   52: getstatic 143	com/tencent/mm/plugin/gallery/a/c:HFZ	Lcom/tencent/mm/plugin/gallery/a/a;
    //   55: astore 4
    //   57: aload 4
    //   59: ifnull +222 -> 281
    //   62: aload 4
    //   64: invokevirtual 152	com/tencent/mm/plugin/gallery/a/a:fzK	()Z
    //   67: iconst_1
    //   68: if_icmpne +213 -> 281
    //   71: iconst_1
    //   72: istore_2
    //   73: iload_2
    //   74: ifne +9 -> 83
    //   77: getstatic 154	com/tencent/mm/plugin/gallery/a/c:HGg	Z
    //   80: ifeq +401 -> 481
    //   83: aload_3
    //   84: ifnull +397 -> 481
    //   87: ldc 156
    //   89: invokestatic 162	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   92: checkcast 156	com/tencent/mm/mj_template/api/d
    //   95: invokeinterface 166 1 0
    //   100: ldc 168
    //   102: invokeinterface 174 2 0
    //   107: ifeq +217 -> 324
    //   110: ldc 176
    //   112: ldc 178
    //   114: invokestatic 183	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   117: aload_3
    //   118: checkcast 185	android/app/Activity
    //   121: astore_3
    //   122: getstatic 187	com/tencent/mm/plugin/gallery/a/c:HFI	Lcom/tencent/mm/protocal/protobuf/ffv;
    //   125: astore_1
    //   126: ldc 176
    //   128: ldc 188
    //   130: invokestatic 183	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   133: aload_0
    //   134: ifnull +124 -> 258
    //   137: aload_3
    //   138: ifnull +120 -> 258
    //   141: getstatic 194	com/tencent/mm/plugin/comm/b/e:xfd	Lcom/tencent/mm/plugin/comm/b/e$a;
    //   144: ldc 196
    //   146: ldc 198
    //   148: iconst_1
    //   149: invokestatic 204	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   152: getstatic 210	com/tencent/mm/plugin/comm/b/c:xeT	Lcom/tencent/mm/plugin/comm/b/c;
    //   155: invokevirtual 215	com/tencent/mm/plugin/comm/b/e$a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Lcom/tencent/mm/plugin/comm/b/c;)V
    //   158: ldc 156
    //   160: invokestatic 162	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   163: checkcast 156	com/tencent/mm/mj_template/api/d
    //   166: astore 4
    //   168: new 217	android/content/Intent
    //   171: dup
    //   172: invokespecial 218	android/content/Intent:<init>	()V
    //   175: astore 5
    //   177: aload_1
    //   178: ifnull +125 -> 303
    //   181: getstatic 224	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   184: astore 6
    //   186: aload 5
    //   188: ldc 226
    //   190: aload_1
    //   191: invokevirtual 232	com/tencent/mm/protocal/protobuf/ffv:toByteArray	()[B
    //   194: invokevirtual 236	android/content/Intent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   197: invokestatic 240	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   200: astore_1
    //   201: aload_1
    //   202: invokestatic 244	kotlin/Result:exceptionOrNull-impl	(Ljava/lang/Object;)Ljava/lang/Throwable;
    //   205: astore_1
    //   206: aload_1
    //   207: ifnull +15 -> 222
    //   210: ldc 176
    //   212: aload_1
    //   213: ldc 246
    //   215: iconst_0
    //   216: anewarray 4	java/lang/Object
    //   219: invokestatic 250	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   222: aload 5
    //   224: ldc 252
    //   226: bipush 101
    //   228: invokevirtual 255	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   231: pop
    //   232: ldc 176
    //   234: ldc_w 257
    //   237: invokestatic 183	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   240: getstatic 263	kotlin/ah:aiuX	Lkotlin/ah;
    //   243: astore_1
    //   244: aload 4
    //   246: aload_3
    //   247: sipush 4384
    //   250: aload_0
    //   251: aload 5
    //   253: invokeinterface 267 5 0
    //   258: ldc 132
    //   260: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   263: iconst_1
    //   264: ireturn
    //   265: aload_3
    //   266: invokestatic 270	com/tencent/mm/plugin/gallery/a/c:h	(Ljava/lang/ref/WeakReference;)Ljava/lang/Object;
    //   269: checkcast 272	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI
    //   272: astore_3
    //   273: goto -246 -> 27
    //   276: iconst_0
    //   277: istore_2
    //   278: goto -230 -> 48
    //   281: iconst_0
    //   282: istore_2
    //   283: goto -210 -> 73
    //   286: astore_1
    //   287: getstatic 224	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   290: astore 6
    //   292: aload_1
    //   293: invokestatic 278	kotlin/ResultKt:createFailure	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   296: invokestatic 240	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   299: astore_1
    //   300: goto -99 -> 201
    //   303: aload 5
    //   305: ldc 252
    //   307: bipush 100
    //   309: invokevirtual 255	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   312: pop
    //   313: ldc 176
    //   315: ldc_w 280
    //   318: invokestatic 183	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   321: goto -81 -> 240
    //   324: ldc 176
    //   326: ldc_w 282
    //   329: getstatic 284	com/tencent/mm/plugin/gallery/a/c:HGi	Z
    //   332: invokestatic 289	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   335: invokestatic 293	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   338: invokestatic 183	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   341: getstatic 284	com/tencent/mm/plugin/gallery/a/c:HGi	Z
    //   344: ifeq +10 -> 354
    //   347: ldc 132
    //   349: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   352: iconst_0
    //   353: ireturn
    //   354: iconst_1
    //   355: putstatic 284	com/tencent/mm/plugin/gallery/a/c:HGi	Z
    //   358: getstatic 194	com/tencent/mm/plugin/comm/b/e:xfd	Lcom/tencent/mm/plugin/comm/b/e$a;
    //   361: ldc 196
    //   363: ldc_w 295
    //   366: iconst_1
    //   367: invokestatic 204	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   370: getstatic 210	com/tencent/mm/plugin/comm/b/c:xeT	Lcom/tencent/mm/plugin/comm/b/c;
    //   373: invokevirtual 215	com/tencent/mm/plugin/comm/b/e$a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Lcom/tencent/mm/plugin/comm/b/c;)V
    //   376: ldc 156
    //   378: invokestatic 162	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   381: checkcast 156	com/tencent/mm/mj_template/api/d
    //   384: invokeinterface 166 1 0
    //   389: astore_3
    //   390: getstatic 141	com/tencent/mm/plugin/gallery/a/c:HGb	Ljava/lang/ref/WeakReference;
    //   393: astore_0
    //   394: aload_0
    //   395: ifnonnull +53 -> 448
    //   398: aconst_null
    //   399: astore_0
    //   400: aload_0
    //   401: ifnonnull +72 -> 473
    //   404: invokestatic 301	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   407: astore_0
    //   408: aload_0
    //   409: ldc_w 303
    //   412: invokestatic 306	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   415: aload_3
    //   416: ldc 168
    //   418: aload_0
    //   419: new 6	com/tencent/mm/plugin/gallery/a/c$b
    //   422: dup
    //   423: aload_1
    //   424: invokespecial 309	com/tencent/mm/plugin/gallery/a/c$b:<init>	(Lkotlin/g/a/a;)V
    //   427: checkcast 126	kotlin/g/a/a
    //   430: getstatic 313	com/tencent/mm/plugin/gallery/a/c$c:HGl	Lcom/tencent/mm/plugin/gallery/a/c$c;
    //   433: checkcast 315	kotlin/g/a/b
    //   436: invokeinterface 318 5 0
    //   441: ldc 132
    //   443: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   446: iconst_1
    //   447: ireturn
    //   448: aload_0
    //   449: invokestatic 270	com/tencent/mm/plugin/gallery/a/c:h	(Ljava/lang/ref/WeakReference;)Ljava/lang/Object;
    //   452: checkcast 272	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI
    //   455: astore_0
    //   456: aload_0
    //   457: ifnonnull +8 -> 465
    //   460: aconst_null
    //   461: astore_0
    //   462: goto -62 -> 400
    //   465: aload_0
    //   466: invokevirtual 321	com/tencent/mm/plugin/gallery/ui/AlbumPreviewUI:getContext	()Landroidx/appcompat/app/AppCompatActivity;
    //   469: astore_0
    //   470: goto -70 -> 400
    //   473: aload_0
    //   474: checkcast 323	android/content/Context
    //   477: astore_0
    //   478: goto -70 -> 408
    //   481: ldc 132
    //   483: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   486: iconst_0
    //   487: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	488	0	paramArrayList	ArrayList<GalleryItem.MediaItem>
    //   0	488	1	parama	kotlin.g.a.a<ah>
    //   47	236	2	i	int
    //   20	396	3	localObject1	Object
    //   30	215	4	localObject2	Object
    //   175	129	5	localIntent	Intent
    //   184	107	6	localCompanion	kotlin.Result.Companion
    // Exception table:
    //   from	to	target	type
    //   181	201	286	finally
  }
  
  public static void aI(ArrayList<GalleryItem.MediaItem> paramArrayList)
  {
    int j = 1;
    AppMethodBeat.i(289278);
    HGe = 0;
    Object localObject2;
    Object localObject1;
    int i;
    if (paramArrayList != null)
    {
      localObject2 = (Iterable)paramArrayList;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      label96:
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        if (((GalleryItem.MediaItem)localObject3).getType() == 2) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label96;
          }
          ((Collection)localObject1).add(localObject3);
          break;
        }
      }
      localObject2 = ((Iterable)localObject1).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = (GalleryItem.MediaItem)((Iterator)localObject2).next();
        int k = HGe;
        if ((localObject1 instanceof GalleryItem.VideoMediaItem))
        {
          localObject1 = (GalleryItem.VideoMediaItem)localObject1;
          label154:
          if (localObject1 != null) {
            break label176;
          }
        }
        label176:
        for (i = 0;; i = ((GalleryItem.VideoMediaItem)localObject1).oTN)
        {
          HGe = i + k;
          break;
          localObject1 = null;
          break label154;
        }
      }
    }
    boolean bool;
    if (isEnable())
    {
      if (paramArrayList != null) {
        break label557;
      }
      i = 0;
      if (i <= 1) {
        break label565;
      }
      bool = true;
      label205:
      HGd = bool;
      localObject1 = HFZ;
      if (localObject1 != null) {
        ((a)localObject1).aH(paramArrayList);
      }
      if ((paramArrayList == null) || (paramArrayList.size() != 1)) {
        break label571;
      }
      i = 1;
      label240:
      if ((i == 0) || (!(p.oK((List)paramArrayList) instanceof GalleryItem.VideoMediaItem))) {
        break label576;
      }
      bool = true;
      label260:
      HGf = bool;
      if (paramArrayList == null) {
        break label592;
      }
      localObject1 = (Iterable)paramArrayList;
      if (((localObject1 instanceof Collection)) && (((Collection)localObject1).isEmpty())) {
        break label587;
      }
      localObject1 = ((Iterable)localObject1).iterator();
      label305:
      if (!((Iterator)localObject1).hasNext()) {
        break label587;
      }
      if (((GalleryItem.MediaItem)((Iterator)localObject1).next()).getType() != 2) {
        break label582;
      }
      i = 1;
      label334:
      if (i == 0) {
        break label585;
      }
      i = 1;
      label340:
      if (i != 1) {
        break label592;
      }
      i = 1;
      label347:
      if (i == 0) {
        break label607;
      }
      localObject1 = (Iterable)paramArrayList;
      if (((localObject1 instanceof Collection)) && (((Collection)localObject1).isEmpty())) {
        break label602;
      }
      localObject1 = ((Iterable)localObject1).iterator();
      label387:
      if (!((Iterator)localObject1).hasNext()) {
        break label602;
      }
      if (((GalleryItem.MediaItem)((Iterator)localObject1).next()).getType() != 1) {
        break label597;
      }
      i = 1;
      label416:
      if (i == 0) {
        break label600;
      }
      i = 1;
      label422:
      if (i == 0) {
        break label607;
      }
      bool = true;
      label429:
      HGg = bool;
      if (bool)
      {
        localObject1 = HFZ;
        if (localObject1 != null) {
          ((a)localObject1).HFK.setValue(Integer.valueOf(a.b.HFU.value));
        }
      }
      localObject1 = HGa;
      if (localObject1 != null)
      {
        paramArrayList = b.hY((List)paramArrayList);
        if (((CharSequence)paramArrayList).length() <= 0) {
          break label613;
        }
        i = j;
        label498:
        if (i == 0) {
          break label618;
        }
        localObject2 = ((d)localObject1).HGn;
        if (localObject2 != null) {
          ((ViewGroup)localObject2).setVisibility(0);
        }
        localObject1 = ((d)localObject1).FxM;
        if (localObject1 != null) {
          ((TextView)localObject1).setText((CharSequence)paramArrayList);
        }
      }
    }
    for (;;)
    {
      HGh.invoke();
      AppMethodBeat.o(289278);
      return;
      label557:
      i = paramArrayList.size();
      break;
      label565:
      bool = false;
      break label205;
      label571:
      i = 0;
      break label240;
      label576:
      bool = false;
      break label260;
      label582:
      i = 0;
      break label334;
      label585:
      break label305;
      label587:
      i = 0;
      break label340;
      label592:
      i = 0;
      break label347;
      label597:
      i = 0;
      break label416;
      label600:
      break label387;
      label602:
      i = 0;
      break label422;
      label607:
      bool = false;
      break label429;
      label613:
      i = 0;
      break label498;
      label618:
      paramArrayList = ((d)localObject1).HGn;
      if (paramArrayList != null) {
        paramArrayList.setVisibility(8);
      }
    }
  }
  
  public static void fzM()
  {
    AppMethodBeat.i(289261);
    Log.i("MicroMsg.MJTemplateHandle", "unbindPreviewUI");
    HGc = null;
    HGa = null;
    AppMethodBeat.o(289261);
  }
  
  public static boolean fzN()
  {
    AppMethodBeat.i(289264);
    a locala = HFZ;
    if ((locala != null) && (locala.HFJ == true))
    {
      i = 1;
      if (i == 0) {
        break label68;
      }
      locala = HFZ;
      if ((locala == null) || (locala.fzK() != true)) {
        break label63;
      }
    }
    label63:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label68;
      }
      AppMethodBeat.o(289264);
      return true;
      i = 0;
      break;
    }
    label68:
    AppMethodBeat.o(289264);
    return false;
  }
  
  public static int fzO()
  {
    int j = 0;
    AppMethodBeat.i(289270);
    Object localObject = HFZ;
    int i;
    if ((localObject != null) && (((a)localObject).HFJ == true)) {
      i = 1;
    }
    while (i != 0)
    {
      if (!HGg)
      {
        localObject = HFZ;
        i = j;
        if (localObject != null)
        {
          i = j;
          if (((a)localObject).fzK() == true) {
            i = 1;
          }
        }
        if (i == 0) {}
      }
      else
      {
        localObject = com.tencent.mm.plugin.sns.m.a.QZO;
        i = com.tencent.mm.plugin.sns.m.a.hlp();
        AppMethodBeat.o(289270);
        return i;
        i = 0;
        continue;
      }
      if (HGf)
      {
        AppMethodBeat.o(289270);
        return 1;
      }
      AppMethodBeat.o(289270);
      return 9;
    }
    AppMethodBeat.o(289270);
    return -1;
  }
  
  public static <T> T h(WeakReference<T> paramWeakReference)
  {
    AppMethodBeat.i(289302);
    s.u(paramWeakReference, "<this>");
    paramWeakReference = paramWeakReference.get();
    AppMethodBeat.o(289302);
    return paramWeakReference;
  }
  
  public static boolean isEnable()
  {
    a locala = HFZ;
    return (locala != null) && (locala.HFJ == true);
  }
  
  public static void report()
  {
    AppMethodBeat.i(289298);
    e.a locala = e.xfd;
    int i;
    if (HFI != null) {
      i = 3;
    }
    for (;;)
    {
      locala.f("SnsTemplate", "source", Integer.valueOf(i));
      locala = e.xfd;
      Object localObject = t.heR();
      s.s(localObject, "checkSnsPostSessionId()");
      locala.f("SnsTemplate", "sessionID", localObject);
      e.xfd.amu("SnsTemplate");
      nWh = true;
      AppMethodBeat.o(289298);
      return;
      localObject = HFZ;
      if (localObject != null)
      {
        localObject = (Integer)((a)localObject).HFL.getValue();
        i = a.b.HFV.value;
        if (localObject == null)
        {
          label108:
          i = 0;
          label110:
          if (i != 1) {
            break label139;
          }
        }
      }
      label139:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label144;
        }
        i = 2;
        break;
        if (((Integer)localObject).intValue() != i) {
          break label108;
        }
        i = 1;
        break label110;
      }
      label144:
      i = 1;
    }
  }
  
  private static final void u(Integer paramInteger)
  {
    AppMethodBeat.i(289307);
    HGh.invoke();
    AppMethodBeat.o(289307);
  }
  
  public final void a(AlbumPreviewUI paramAlbumPreviewUI)
  {
    Object localObject1 = null;
    AppMethodBeat.i(289324);
    Object localObject2 = e.xfd;
    localObject2 = ai.cz(SnsTemplateReportStruct.class).klu();
    s.checkNotNull(localObject2);
    e.a.gt("SnsTemplate", (String)localObject2);
    nWh = false;
    Log.i("MicroMsg.MJTemplateHandle", "[" + hashCode() + " bind ui:" + Integer.valueOf(paramAlbumPreviewUI.hashCode()) + ']');
    HGb = new WeakReference(paramAlbumPreviewUI);
    localObject2 = HFZ;
    if (localObject2 != null) {
      ((a)localObject2).HFH = null;
    }
    HFZ = null;
    localObject2 = paramAlbumPreviewUI.getIntent();
    if (localObject2 == null) {}
    for (;;)
    {
      HFI = (ffv)localObject1;
      localObject1 = new a(new WeakReference(paramAlbumPreviewUI), HFI);
      localObject2 = (kotlin.g.a.a)c.a.HGj;
      s.u(localObject2, "<set-?>");
      ((a)localObject1).HFS = ((kotlin.g.a.a)localObject2);
      HFZ = (a)localObject1;
      localObject1 = ((a)localObject1).HFL;
      if (localObject1 != null) {
        ((LiveData)localObject1).a((q)paramAlbumPreviewUI, c..ExternalSyntheticLambda0.INSTANCE);
      }
      AppMethodBeat.o(289324);
      return;
      localObject2 = ((Intent)localObject2).getByteArrayExtra("album_template_info");
      if (localObject2 != null)
      {
        localObject1 = new ffv();
        com.tencent.mm.bx.a locala = (com.tencent.mm.bx.a)localObject1;
        try
        {
          locala.parseFrom((byte[])localObject2);
        }
        catch (Exception localException)
        {
          Log.printDebugStack("safeParser", "", new Object[] { localException });
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(kotlin.g.a.a<ah> parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    public static final c HGl;
    
    static
    {
      AppMethodBeat.i(289253);
      HGl = new c();
      AppMethodBeat.o(289253);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    public static final d HGm;
    
    static
    {
      AppMethodBeat.i(289260);
      HGm = new d();
      AppMethodBeat.o(289260);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.a.c
 * JD-Core Version:    0.7.0.1
 */