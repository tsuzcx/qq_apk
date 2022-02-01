package com.tencent.mm.plugin.finder.publish;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Parcelable;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.kernel.b;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.finder.feed.ui.FinderPostPreviewUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderSharePostUI;
import com.tencent.mm.plugin.finder.report.v;
import com.tencent.mm.plugin.finder.ui.FinderAlbumUI;
import com.tencent.mm.plugin.finder.ui.FinderCropAvatarUI;
import com.tencent.mm.plugin.finder.ui.FinderPostRouterUI;
import com.tencent.mm.plugin.finder.ui.FinderPostTransitUI;
import com.tencent.mm.plugin.finder.ui.FinderPostUI;
import com.tencent.mm.plugin.finder.ui.FinderSelectCoverUI;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.djh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.ViewAnimHelper.ViewInfo;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/publish/PublishRouterApi;", "Lcom/tencent/mm/plugin/finder/publish/IPublishRouterApi;", "()V", "TAG", "", "enterCropAvatarUI", "", "context", "Landroid/app/Activity;", "i", "Landroid/content/Intent;", "rc", "", "enterCropAvatarUIFromProfile", "intent", "filePath", "resultFileName", "requestCode", "enterCropProfileBgUI", "enterFinderPostAlbumUI", "Landroid/content/Context;", "mediaType", "maxCount", "forResult", "", "(Landroid/content/Context;Landroid/content/Intent;IILjava/lang/Boolean;Ljava/lang/Integer;)V", "enterFinderPostRouterUI", "enterFinderPostTransitUI", "enterFinderPostUI", "enterFinderPostUIWithEventInfo", "optionalInfoJson", "Lorg/json/JSONObject;", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderPostCallbackApi;", "enterFinderSharePostUI", "enterFinderTemplateAlbumUI", "enterFinderTemplateRecordUI", "enterPostUI", "json", "fromType", "enterPreviewAtTimelineUI", "enterSelectCoverUI", "viewInfo", "Lcom/tencent/mm/view/ViewAnimHelper$ViewInfo;", "localContent", "Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "reqCode", "postLongVideo", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  implements e
{
  public static final i FhR;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(330586);
    FhR = new i();
    TAG = "Finder.PublishRouterApi";
    AppMethodBeat.o(330586);
  }
  
  private final void aG(Intent paramIntent)
  {
    AppMethodBeat.i(330573);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.h.baC();
    paramIntent.putExtra("post_id", b.aZs() + '_' + Util.nowMilliSecond());
    localObject = v.FrN;
    v.aP(6, false);
    localObject = MMApplicationContext.getContext();
    s.s(localObject, "getContext()");
    enterFinderPostUI((Context)localObject, paramIntent);
    AppMethodBeat.o(330573);
  }
  
  public final void R(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(330601);
    s.u(paramContext, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (!(paramContext instanceof Activity)) {}
    for (paramIntent = localIntent;; paramIntent = null)
    {
      if (paramIntent != null) {
        paramIntent.addFlags(268435456);
      }
      localIntent.addFlags(67108864);
      localIntent.setClass(paramContext, FinderSharePostUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/publish/PublishRouterApi", "enterFinderSharePostUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/publish/PublishRouterApi", "enterFinderSharePostUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(330601);
      return;
    }
  }
  
  public final void S(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(330648);
    s.u(paramContext, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (!(paramContext instanceof Activity)) {}
    for (paramIntent = localIntent;; paramIntent = null)
    {
      if (paramIntent != null) {
        paramIntent.addFlags(268435456);
      }
      localIntent.setClass(paramContext, FinderPostPreviewUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/publish/PublishRouterApi", "enterPreviewAtTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/publish/PublishRouterApi", "enterPreviewAtTimelineUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(330648);
      return;
    }
  }
  
  public final void a(Activity paramActivity, Intent paramIntent, String paramString1, String paramString2)
  {
    AppMethodBeat.i(330670);
    s.u(paramActivity, "context");
    s.u(paramIntent, "intent");
    s.u(paramString1, "filePath");
    s.u(paramString2, "resultFileName");
    paramIntent.setClass((Context)paramActivity, FinderCropAvatarUI.class);
    paramIntent.putExtra("key_crop_style", 1);
    paramIntent.putExtra("key_crop_source", 2);
    paramIntent.putExtra("key_source_img_path", paramString1);
    paramIntent.putExtra("key_result_file_name", paramString2);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, c.a(10008, new com.tencent.mm.hellhoundlib.b.a()).cG(paramIntent).aYi(), "com/tencent/mm/plugin/finder/publish/PublishRouterApi", "enterCropAvatarUIFromProfile", "(Landroid/app/Activity;Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;I)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    AppMethodBeat.o(330670);
  }
  
  public final void a(Activity paramActivity, ViewAnimHelper.ViewInfo paramViewInfo, djh paramdjh, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(330611);
    s.u(paramActivity, "context");
    s.u(paramViewInfo, "viewInfo");
    s.u(paramdjh, "localContent");
    Intent localIntent = new Intent();
    localIntent.setClass((Context)paramActivity, FinderSelectCoverUI.class);
    localIntent.putExtra("media_list_", paramdjh.toByteArray());
    localIntent.putExtra("crop_info", (Parcelable)paramViewInfo);
    localIntent.putExtra("media_list_count", paramdjh.mediaList.size());
    localIntent.putExtra("isLongVideoPost", paramBoolean);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent).aYi(), "com/tencent/mm/plugin/finder/publish/PublishRouterApi", "enterSelectCoverUI", "(Landroid/app/Activity;Lcom/tencent/mm/view/ViewAnimHelper$ViewInfo;Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;IZ)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    AppMethodBeat.o(330611);
  }
  
  public final void a(Context paramContext, Intent paramIntent, Boolean paramBoolean, Integer paramInteger)
  {
    AppMethodBeat.i(330622);
    s.u(paramContext, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (!(paramContext instanceof Activity))
    {
      paramIntent = localIntent;
      if (paramIntent != null) {
        paramIntent.addFlags(268435456);
      }
      localIntent.setClass(paramContext, FinderAlbumUI.class);
      paramIntent = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (!com.tencent.mm.plugin.finder.storage.d.eRn()) {
        localIntent.putExtra("key_can_select_video_and_pic", true);
      }
      localIntent.putExtra("is_hide_album_footer", true);
      localIntent.putExtra("show_header_view", false);
      localIntent.putExtra("max_select_count", 9);
      localIntent.putExtra("query_source_type", 25);
      localIntent.putExtra("query_media_type", 3);
      paramIntent = com.tencent.mm.plugin.finder.storage.d.FAy;
      localIntent.putExtra("album_video_max_duration", com.tencent.mm.plugin.finder.storage.d.ePW());
      paramIntent = com.tencent.mm.plugin.finder.storage.d.FAy;
      localIntent.putExtra("album_video_min_duration", com.tencent.mm.plugin.finder.storage.d.ePV().minDuration);
      paramIntent = (CharSequence)localIntent.getStringExtra("KEY_FINDER_POST_ORIGIN_MUSIC_ID");
      if ((paramIntent != null) && (paramIntent.length() != 0)) {
        break label322;
      }
      i = 1;
      label194:
      if (i != 0) {
        break label328;
      }
      i = 1;
      label202:
      if ((i == 0) && (((com.tencent.mm.mj_template.api.d)com.tencent.mm.kernel.h.az(com.tencent.mm.mj_template.api.d.class)).getFinderMaasConfig().bxh())) {
        localIntent.putExtra("key_filter_hdr_video", true);
      }
      if ((!s.p(paramBoolean, Boolean.TRUE)) || (!(paramContext instanceof Activity))) {
        break label344;
      }
      paramContext = (Activity)paramContext;
      if (paramInteger != null) {
        break label334;
      }
    }
    label322:
    label328:
    label334:
    for (int i = -1;; i = paramInteger.intValue())
    {
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, c.a(i, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent).aYi(), "com/tencent/mm/plugin/finder/publish/PublishRouterApi", "enterFinderPostAlbumUI", "(Landroid/content/Context;Landroid/content/Intent;IILjava/lang/Boolean;Ljava/lang/Integer;)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
      AppMethodBeat.o(330622);
      return;
      paramIntent = null;
      break;
      i = 0;
      break label194;
      i = 0;
      break label202;
    }
    label344:
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/publish/PublishRouterApi", "enterFinderPostAlbumUI", "(Landroid/content/Context;Landroid/content/Intent;IILjava/lang/Boolean;Ljava/lang/Integer;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/publish/PublishRouterApi", "enterFinderPostAlbumUI", "(Landroid/content/Context;Landroid/content/Intent;IILjava/lang/Boolean;Ljava/lang/Integer;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(330622);
  }
  
  /* Error */
  public final void a(Context paramContext, String paramString, int paramInt, com.tencent.mm.plugin.findersdk.a.bj parambj)
  {
    // Byte code:
    //   0: ldc_w 397
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ldc 166
    //   9: invokestatic 169	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_2
    //   13: ldc_w 398
    //   16: invokestatic 169	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   19: aload 4
    //   21: ldc_w 399
    //   24: invokestatic 169	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   27: getstatic 405	com/tencent/mm/plugin/finder/post/a:EST	Lcom/tencent/mm/plugin/finder/post/a;
    //   30: astore_1
    //   31: aload 4
    //   33: invokestatic 408	com/tencent/mm/plugin/finder/post/a:a	(Lcom/tencent/mm/plugin/findersdk/a/bj;)V
    //   36: new 132	android/content/Intent
    //   39: dup
    //   40: invokespecial 170	android/content/Intent:<init>	()V
    //   43: astore_1
    //   44: getstatic 81	com/tencent/mm/plugin/finder/publish/i:TAG	Ljava/lang/String;
    //   47: new 96	java/lang/StringBuilder
    //   50: dup
    //   51: ldc_w 410
    //   54: invokespecial 413	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   57: iload_3
    //   58: invokevirtual 416	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   61: ldc_w 418
    //   64: invokevirtual 421	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_2
    //   68: invokevirtual 421	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 426	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   77: new 428	org/json/JSONObject
    //   80: dup
    //   81: aload_2
    //   82: invokespecial 429	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   85: astore 7
    //   87: aload 7
    //   89: ldc_w 431
    //   92: invokevirtual 435	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   95: astore 9
    //   97: aload 7
    //   99: ldc_w 437
    //   102: invokevirtual 435	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   105: astore 8
    //   107: aload 7
    //   109: ldc_w 439
    //   112: invokevirtual 435	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   115: astore 6
    //   117: new 441	com/tencent/mm/protocal/protobuf/FinderJumpInfo
    //   120: dup
    //   121: invokespecial 442	com/tencent/mm/protocal/protobuf/FinderJumpInfo:<init>	()V
    //   124: astore_2
    //   125: aload 9
    //   127: ifnull +914 -> 1041
    //   130: iload_3
    //   131: tableswitch	default:+17 -> 148, 1:+440->571
    //   149: iconst_5
    //   150: ifnull +903 -> 1053
    //   153: new 444	com/tencent/mm/protocal/protobuf/bue
    //   156: dup
    //   157: invokespecial 445	com/tencent/mm/protocal/protobuf/bue:<init>	()V
    //   160: astore 9
    //   162: aload 9
    //   164: aload 8
    //   166: ldc_w 447
    //   169: invokevirtual 450	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   172: putfield 452	com/tencent/mm/protocal/protobuf/bue:clientId	Ljava/lang/String;
    //   175: aload 9
    //   177: aload 8
    //   179: ldc_w 454
    //   182: invokevirtual 450	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   185: putfield 456	com/tencent/mm/protocal/protobuf/bue:mediaUrl	Ljava/lang/String;
    //   188: aload 9
    //   190: aload 8
    //   192: ldc_w 458
    //   195: invokevirtual 450	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   198: putfield 460	com/tencent/mm/protocal/protobuf/bue:thumbUrl	Ljava/lang/String;
    //   201: aload 9
    //   203: aload 8
    //   205: ldc_w 462
    //   208: ldc_w 463
    //   211: invokevirtual 467	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   214: putfield 469	com/tencent/mm/protocal/protobuf/bue:coverUrl	Ljava/lang/String;
    //   217: aload 9
    //   219: aload 8
    //   221: ldc_w 471
    //   224: invokevirtual 475	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   227: putfield 477	com/tencent/mm/protocal/protobuf/bue:fileSize	I
    //   230: aload 9
    //   232: aload 8
    //   234: ldc_w 479
    //   237: invokevirtual 475	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   240: putfield 481	com/tencent/mm/protocal/protobuf/bue:bitrate	I
    //   243: aload 9
    //   245: aload 8
    //   247: ldc_w 483
    //   250: invokevirtual 475	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   253: putfield 485	com/tencent/mm/protocal/protobuf/bue:mediaWidth	I
    //   256: aload 9
    //   258: aload 8
    //   260: ldc_w 487
    //   263: invokevirtual 475	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   266: putfield 489	com/tencent/mm/protocal/protobuf/bue:mediaHeight	I
    //   269: aload 9
    //   271: aload 8
    //   273: ldc_w 491
    //   276: invokevirtual 475	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   279: putfield 493	com/tencent/mm/protocal/protobuf/bue:duration	I
    //   282: aload 9
    //   284: aload 8
    //   286: ldc_w 495
    //   289: invokevirtual 450	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   292: putfield 498	com/tencent/mm/protocal/protobuf/bue:EUn	Ljava/lang/String;
    //   295: aload 9
    //   297: aload 8
    //   299: ldc_w 500
    //   302: invokevirtual 475	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   305: putfield 503	com/tencent/mm/protocal/protobuf/bue:aabW	I
    //   308: aload 9
    //   310: aload 8
    //   312: ldc_w 505
    //   315: ldc_w 463
    //   318: invokevirtual 467	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   321: putfield 508	com/tencent/mm/protocal/protobuf/bue:aabX	Ljava/lang/String;
    //   324: aload 9
    //   326: aload 8
    //   328: ldc_w 510
    //   331: invokevirtual 475	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   334: putfield 513	com/tencent/mm/protocal/protobuf/bue:EUp	I
    //   337: aload 9
    //   339: getfield 493	com/tencent/mm/protocal/protobuf/bue:duration	I
    //   342: bipush 60
    //   344: if_icmple +12 -> 356
    //   347: aload_1
    //   348: ldc_w 299
    //   351: iconst_1
    //   352: invokevirtual 302	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   355: pop
    //   356: aload_1
    //   357: ldc_w 515
    //   360: iconst_4
    //   361: invokevirtual 239	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   364: pop
    //   365: aload_1
    //   366: ldc_w 517
    //   369: aload 9
    //   371: invokevirtual 518	com/tencent/mm/protocal/protobuf/bue:toByteArray	()[B
    //   374: invokevirtual 278	android/content/Intent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   377: pop
    //   378: aload 6
    //   380: ifnull +101 -> 481
    //   383: aload_1
    //   384: ldc_w 520
    //   387: aload 6
    //   389: ldc_w 522
    //   392: invokevirtual 524	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   395: invokevirtual 136	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   398: pop
    //   399: aload 6
    //   401: ldc_w 526
    //   404: invokevirtual 530	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   407: ifeq +74 -> 481
    //   410: aload 6
    //   412: ldc_w 526
    //   415: invokevirtual 533	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   418: astore 8
    //   420: new 535	com/tencent/mm/protocal/protobuf/brx
    //   423: dup
    //   424: invokespecial 536	com/tencent/mm/protocal/protobuf/brx:<init>	()V
    //   427: astore 9
    //   429: aload 9
    //   431: aload 8
    //   433: ldc_w 538
    //   436: invokevirtual 475	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   439: putfield 540	com/tencent/mm/protocal/protobuf/brx:businessType	I
    //   442: aload 9
    //   444: aload 8
    //   446: ldc_w 542
    //   449: invokevirtual 450	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   452: putfield 545	com/tencent/mm/protocal/protobuf/brx:Rfi	Ljava/lang/String;
    //   455: aload 9
    //   457: aload 8
    //   459: ldc_w 547
    //   462: invokevirtual 450	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   465: putfield 550	com/tencent/mm/protocal/protobuf/brx:ZZV	Ljava/lang/String;
    //   468: aload_1
    //   469: ldc_w 552
    //   472: aload 9
    //   474: invokevirtual 553	com/tencent/mm/protocal/protobuf/brx:toByteArray	()[B
    //   477: invokevirtual 278	android/content/Intent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   480: pop
    //   481: aload 6
    //   483: ifnull +622 -> 1105
    //   486: aload 6
    //   488: ldc_w 555
    //   491: invokevirtual 530	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   494: ifeq +611 -> 1105
    //   497: iconst_1
    //   498: istore_3
    //   499: aload 7
    //   501: ldc_w 557
    //   504: invokevirtual 524	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   507: checkcast 356	java/lang/CharSequence
    //   510: astore 7
    //   512: aload 7
    //   514: ifnull +13 -> 527
    //   517: aload 7
    //   519: invokeinterface 359 1 0
    //   524: ifne +586 -> 1110
    //   527: iconst_1
    //   528: istore 5
    //   530: iload 5
    //   532: ifne +584 -> 1116
    //   535: new 559	com/tencent/mm/autogen/a/sc
    //   538: dup
    //   539: invokespecial 560	com/tencent/mm/autogen/a/sc:<init>	()V
    //   542: astore_1
    //   543: aload_1
    //   544: getfield 564	com/tencent/mm/autogen/a/sc:hVe	Lcom/tencent/mm/autogen/a/sc$a;
    //   547: aload_2
    //   548: putfield 570	com/tencent/mm/autogen/a/sc$a:hVf	Lcom/tencent/mm/protocal/protobuf/FinderJumpInfo;
    //   551: aload_1
    //   552: invokevirtual 573	com/tencent/mm/autogen/a/sc:publish	()Z
    //   555: pop
    //   556: getstatic 405	com/tencent/mm/plugin/finder/post/a:EST	Lcom/tencent/mm/plugin/finder/post/a;
    //   559: astore_1
    //   560: aconst_null
    //   561: invokestatic 408	com/tencent/mm/plugin/finder/post/a:a	(Lcom/tencent/mm/plugin/findersdk/a/bj;)V
    //   564: ldc_w 397
    //   567: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   570: return
    //   571: aload_2
    //   572: aload 9
    //   574: ldc_w 575
    //   577: invokevirtual 475	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   580: putfield 578	com/tencent/mm/protocal/protobuf/FinderJumpInfo:jumpinfo_type	I
    //   583: aload_2
    //   584: aload 9
    //   586: ldc_w 538
    //   589: invokevirtual 581	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   592: putfield 584	com/tencent/mm/protocal/protobuf/FinderJumpInfo:business_type	I
    //   595: aload_2
    //   596: aload 9
    //   598: ldc_w 586
    //   601: invokevirtual 524	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   604: putfield 588	com/tencent/mm/protocal/protobuf/FinderJumpInfo:wording	Ljava/lang/String;
    //   607: aload_2
    //   608: aload 9
    //   610: ldc_w 590
    //   613: invokevirtual 524	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   616: putfield 593	com/tencent/mm/protocal/protobuf/FinderJumpInfo:icon_url	Ljava/lang/String;
    //   619: aload_2
    //   620: aload 9
    //   622: ldc_w 595
    //   625: invokevirtual 524	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   628: putfield 598	com/tencent/mm/protocal/protobuf/FinderJumpInfo:recommend_reason	Ljava/lang/String;
    //   631: aload_2
    //   632: aload 9
    //   634: ldc_w 600
    //   637: invokevirtual 524	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   640: putfield 603	com/tencent/mm/protocal/protobuf/FinderJumpInfo:report_info	Ljava/lang/String;
    //   643: aload_2
    //   644: aload 9
    //   646: ldc_w 605
    //   649: invokevirtual 524	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   652: putfield 608	com/tencent/mm/protocal/protobuf/FinderJumpInfo:ext_info	Ljava/lang/String;
    //   655: aload 9
    //   657: ldc_w 610
    //   660: invokevirtual 530	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   663: ifeq +72 -> 735
    //   666: aload 9
    //   668: ldc_w 610
    //   671: invokevirtual 533	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   674: astore 11
    //   676: new 612	com/tencent/mm/protocal/protobuf/MiniAppInfo
    //   679: dup
    //   680: invokespecial 613	com/tencent/mm/protocal/protobuf/MiniAppInfo:<init>	()V
    //   683: astore 10
    //   685: aload 10
    //   687: aload 11
    //   689: ldc_w 615
    //   692: invokevirtual 524	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   695: putfield 618	com/tencent/mm/protocal/protobuf/MiniAppInfo:fetch_info_id	Ljava/lang/String;
    //   698: aload 10
    //   700: aload 11
    //   702: ldc_w 620
    //   705: invokevirtual 524	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   708: putfield 623	com/tencent/mm/protocal/protobuf/MiniAppInfo:app_id	Ljava/lang/String;
    //   711: aload 10
    //   713: aload 11
    //   715: ldc_w 625
    //   718: invokevirtual 524	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   721: putfield 627	com/tencent/mm/protocal/protobuf/MiniAppInfo:path	Ljava/lang/String;
    //   724: getstatic 633	kotlin/ah:aiuX	Lkotlin/ah;
    //   727: astore 11
    //   729: aload_2
    //   730: aload 10
    //   732: putfield 637	com/tencent/mm/protocal/protobuf/FinderJumpInfo:mini_app_info	Lcom/tencent/mm/protocal/protobuf/MiniAppInfo;
    //   735: aload 9
    //   737: ldc_w 639
    //   740: invokevirtual 530	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   743: ifeq +59 -> 802
    //   746: aload 9
    //   748: ldc_w 639
    //   751: invokevirtual 533	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   754: astore 11
    //   756: new 641	com/tencent/mm/protocal/protobuf/Html5Info
    //   759: dup
    //   760: invokespecial 642	com/tencent/mm/protocal/protobuf/Html5Info:<init>	()V
    //   763: astore 10
    //   765: aload 10
    //   767: aload 11
    //   769: ldc_w 644
    //   772: invokevirtual 524	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   775: putfield 646	com/tencent/mm/protocal/protobuf/Html5Info:url	Ljava/lang/String;
    //   778: aload 10
    //   780: aload 11
    //   782: ldc_w 648
    //   785: invokevirtual 581	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   788: putfield 650	com/tencent/mm/protocal/protobuf/Html5Info:style	I
    //   791: getstatic 633	kotlin/ah:aiuX	Lkotlin/ah;
    //   794: astore 11
    //   796: aload_2
    //   797: aload 10
    //   799: putfield 654	com/tencent/mm/protocal/protobuf/FinderJumpInfo:html5_info	Lcom/tencent/mm/protocal/protobuf/Html5Info;
    //   802: aload 9
    //   804: ldc_w 656
    //   807: invokevirtual 530	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   810: ifeq +59 -> 869
    //   813: aload 9
    //   815: ldc_w 656
    //   818: invokevirtual 533	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   821: astore 11
    //   823: new 658	com/tencent/mm/protocal/protobuf/NativeInfo
    //   826: dup
    //   827: invokespecial 659	com/tencent/mm/protocal/protobuf/NativeInfo:<init>	()V
    //   830: astore 10
    //   832: aload 10
    //   834: aload 11
    //   836: ldc_w 661
    //   839: invokevirtual 581	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   842: putfield 664	com/tencent/mm/protocal/protobuf/NativeInfo:native_type	I
    //   845: aload 10
    //   847: aload 11
    //   849: ldc_w 666
    //   852: invokevirtual 524	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   855: putfield 669	com/tencent/mm/protocal/protobuf/NativeInfo:necessary_params	Ljava/lang/String;
    //   858: getstatic 633	kotlin/ah:aiuX	Lkotlin/ah;
    //   861: astore 11
    //   863: aload_2
    //   864: aload 10
    //   866: putfield 673	com/tencent/mm/protocal/protobuf/FinderJumpInfo:native_info	Lcom/tencent/mm/protocal/protobuf/NativeInfo;
    //   869: aload 9
    //   871: ldc_w 675
    //   874: invokevirtual 530	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   877: ifeq +124 -> 1001
    //   880: aload 9
    //   882: ldc_w 675
    //   885: invokevirtual 533	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   888: astore 10
    //   890: new 677	com/tencent/mm/protocal/protobuf/SchemaInfo
    //   893: dup
    //   894: invokespecial 678	com/tencent/mm/protocal/protobuf/SchemaInfo:<init>	()V
    //   897: astore 9
    //   899: aload 9
    //   901: aload 10
    //   903: ldc_w 680
    //   906: invokevirtual 524	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   909: putfield 683	com/tencent/mm/protocal/protobuf/SchemaInfo:universal_link	Ljava/lang/String;
    //   912: aload 9
    //   914: aload 10
    //   916: ldc_w 685
    //   919: invokevirtual 524	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   922: putfield 687	com/tencent/mm/protocal/protobuf/SchemaInfo:scheme	Ljava/lang/String;
    //   925: aload 9
    //   927: aload 10
    //   929: ldc_w 689
    //   932: invokevirtual 524	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   935: putfield 692	com/tencent/mm/protocal/protobuf/SchemaInfo:appstore_link	Ljava/lang/String;
    //   938: aload 9
    //   940: aload 10
    //   942: ldc_w 694
    //   945: invokevirtual 524	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   948: putfield 697	com/tencent/mm/protocal/protobuf/SchemaInfo:android_appstore_scheme	Ljava/lang/String;
    //   951: aload 9
    //   953: aload 10
    //   955: ldc_w 699
    //   958: invokevirtual 524	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   961: putfield 702	com/tencent/mm/protocal/protobuf/SchemaInfo:android_app_public_key	Ljava/lang/String;
    //   964: aload 9
    //   966: aload 10
    //   968: ldc_w 704
    //   971: invokevirtual 524	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   974: putfield 707	com/tencent/mm/protocal/protobuf/SchemaInfo:android_universal_link	Ljava/lang/String;
    //   977: aload 9
    //   979: aload 10
    //   981: ldc_w 709
    //   984: invokevirtual 524	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   987: putfield 712	com/tencent/mm/protocal/protobuf/SchemaInfo:android_package	Ljava/lang/String;
    //   990: getstatic 633	kotlin/ah:aiuX	Lkotlin/ah;
    //   993: astore 10
    //   995: aload_2
    //   996: aload 9
    //   998: putfield 716	com/tencent/mm/protocal/protobuf/FinderJumpInfo:schema_info	Lcom/tencent/mm/protocal/protobuf/SchemaInfo;
    //   1001: aload_2
    //   1002: iconst_4
    //   1003: putfield 719	com/tencent/mm/protocal/protobuf/FinderJumpInfo:source	I
    //   1006: aload_1
    //   1007: ldc_w 721
    //   1010: aload_2
    //   1011: invokevirtual 722	com/tencent/mm/protocal/protobuf/FinderJumpInfo:toByteArray	()[B
    //   1014: invokevirtual 278	android/content/Intent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   1017: pop
    //   1018: goto -870 -> 148
    //   1021: astore 9
    //   1023: getstatic 81	com/tencent/mm/plugin/finder/publish/i:TAG	Ljava/lang/String;
    //   1026: aload 9
    //   1028: ldc_w 723
    //   1031: iconst_0
    //   1032: anewarray 4	java/lang/Object
    //   1035: invokestatic 727	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1038: goto -890 -> 148
    //   1041: getstatic 81	com/tencent/mm/plugin/finder/publish/i:TAG	Ljava/lang/String;
    //   1044: ldc_w 729
    //   1047: invokestatic 426	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1050: goto -902 -> 148
    //   1053: getstatic 81	com/tencent/mm/plugin/finder/publish/i:TAG	Ljava/lang/String;
    //   1056: ldc_w 731
    //   1059: invokestatic 426	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1062: goto -684 -> 378
    //   1065: astore 8
    //   1067: getstatic 81	com/tencent/mm/plugin/finder/publish/i:TAG	Ljava/lang/String;
    //   1070: aload 8
    //   1072: ldc_w 723
    //   1075: iconst_0
    //   1076: anewarray 4	java/lang/Object
    //   1079: invokestatic 727	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1082: goto -704 -> 378
    //   1085: astore 8
    //   1087: getstatic 81	com/tencent/mm/plugin/finder/publish/i:TAG	Ljava/lang/String;
    //   1090: aload 8
    //   1092: ldc_w 733
    //   1095: iconst_0
    //   1096: anewarray 4	java/lang/Object
    //   1099: invokestatic 727	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1102: goto -621 -> 481
    //   1105: iconst_0
    //   1106: istore_3
    //   1107: goto -608 -> 499
    //   1110: iconst_0
    //   1111: istore 5
    //   1113: goto -583 -> 530
    //   1116: iload_3
    //   1117: ifne +15 -> 1132
    //   1120: aload_0
    //   1121: aload_1
    //   1122: invokespecial 93	com/tencent/mm/plugin/finder/publish/i:aG	(Landroid/content/Intent;)V
    //   1125: ldc_w 397
    //   1128: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1131: return
    //   1132: aload 6
    //   1134: ldc_w 734
    //   1137: invokestatic 160	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1140: aload 6
    //   1142: ldc_w 555
    //   1145: invokevirtual 533	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1148: astore 6
    //   1150: aload 6
    //   1152: ldc_w 736
    //   1155: invokevirtual 524	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1158: astore_2
    //   1159: aload 6
    //   1161: ldc_w 738
    //   1164: invokevirtual 524	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1167: astore 6
    //   1169: getstatic 744	com/tencent/mm/plugin/finder/upload/i:Gcb	Lcom/tencent/mm/plugin/finder/upload/i;
    //   1172: astore 7
    //   1174: aload_2
    //   1175: ldc_w 746
    //   1178: invokestatic 160	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1181: aload 6
    //   1183: ldc_w 738
    //   1186: invokestatic 160	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1189: aload_2
    //   1190: aload 6
    //   1192: new 748	com/tencent/mm/plugin/finder/publish/i$a
    //   1195: dup
    //   1196: aload_1
    //   1197: invokespecial 750	com/tencent/mm/plugin/finder/publish/i$a:<init>	(Landroid/content/Intent;)V
    //   1200: checkcast 752	kotlin/g/a/b
    //   1203: invokestatic 755	com/tencent/mm/plugin/finder/upload/i:b	(Ljava/lang/String;Ljava/lang/String;Lkotlin/g/a/b;)V
    //   1206: ldc_w 397
    //   1209: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1212: return
    //   1213: astore_1
    //   1214: getstatic 81	com/tencent/mm/plugin/finder/publish/i:TAG	Ljava/lang/String;
    //   1217: aload_1
    //   1218: checkcast 757	java/lang/Throwable
    //   1221: ldc_w 723
    //   1224: iconst_0
    //   1225: anewarray 4	java/lang/Object
    //   1228: invokestatic 727	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1231: aload 4
    //   1233: iconst_1
    //   1234: ldc_w 759
    //   1237: invokeinterface 764 3 0
    //   1242: ldc_w 397
    //   1245: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1248: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1249	0	this	i
    //   0	1249	1	paramContext	Context
    //   0	1249	2	paramString	String
    //   0	1249	3	paramInt	int
    //   0	1249	4	parambj	com.tencent.mm.plugin.findersdk.a.bj
    //   528	584	5	i	int
    //   115	1076	6	localObject1	Object
    //   85	1088	7	localObject2	Object
    //   105	353	8	localJSONObject	org.json.JSONObject
    //   1065	6	8	localThrowable1	java.lang.Throwable
    //   1085	6	8	localThrowable2	java.lang.Throwable
    //   95	902	9	localObject3	Object
    //   1021	6	9	localThrowable3	java.lang.Throwable
    //   683	311	10	localObject4	Object
    //   674	188	11	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   571	735	1021	finally
    //   735	802	1021	finally
    //   802	869	1021	finally
    //   869	1001	1021	finally
    //   1001	1018	1021	finally
    //   1041	1050	1021	finally
    //   153	356	1065	finally
    //   356	378	1065	finally
    //   1053	1062	1065	finally
    //   383	481	1085	finally
    //   1140	1206	1213	java/lang/Exception
  }
  
  public final void c(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(330631);
    s.u(paramActivity, "context");
    if (paramIntent == null) {
      paramIntent = new Intent();
    }
    for (;;)
    {
      paramIntent.setClass((Context)paramActivity, FinderAlbumUI.class);
      Object localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (!com.tencent.mm.plugin.finder.storage.d.eRn()) {
        paramIntent.putExtra("key_can_select_video_and_pic", true);
      }
      paramIntent.putExtra("show_header_view", false);
      paramIntent.putExtra("query_source_type", 32);
      paramIntent.putExtra("query_media_type", 3);
      localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
      paramIntent.putExtra("album_video_max_duration", com.tencent.mm.plugin.finder.storage.d.ePW());
      localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
      paramIntent.putExtra("album_video_min_duration", com.tencent.mm.plugin.finder.storage.d.ePV().minDuration);
      paramIntent.putExtra("key_filter_hdr_video", true);
      paramIntent.putExtra("key_max_video_duration", 300);
      localObject = as.GSQ;
      as.a.a((Context)paramActivity, paramIntent, 0L, 0, false, 124);
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a()).cG(paramIntent).aYi(), "com/tencent/mm/plugin/finder/publish/PublishRouterApi", "enterFinderTemplateAlbumUI", "(Landroid/app/Activity;Landroid/content/Intent;II)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
      AppMethodBeat.o(330631);
      return;
    }
  }
  
  public final void c(Activity paramActivity, String paramString1, String paramString2)
  {
    AppMethodBeat.i(330664);
    s.u(paramActivity, "context");
    s.u(paramString1, "filePath");
    s.u(paramString2, "resultFileName");
    Intent localIntent = new Intent();
    localIntent.setClass((Context)paramActivity, FinderCropAvatarUI.class);
    localIntent.putExtra("key_crop_style", 2);
    localIntent.putExtra("key_crop_source", 3);
    localIntent.putExtra("key_source_img_path", paramString1);
    localIntent.putExtra("key_result_file_name", paramString2);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, c.a(2002, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent).aYi(), "com/tencent/mm/plugin/finder/publish/PublishRouterApi", "enterCropProfileBgUI", "(Landroid/app/Activity;Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;I)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    AppMethodBeat.o(330664);
  }
  
  public final void d(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(330653);
    s.u(paramActivity, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass((Context)paramActivity, FinderCropAvatarUI.class);
    localIntent.putExtra("key_result_file_name", "finder_avatar.tmp");
    localIntent.putExtra("key_crop_source", 1);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent).aYi(), "com/tencent/mm/plugin/finder/publish/PublishRouterApi", "enterCropAvatarUI", "(Landroid/app/Activity;Landroid/content/Intent;I)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    AppMethodBeat.o(330653);
  }
  
  public final void enterFinderPostRouterUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(330596);
    s.u(paramContext, "context");
    Object localObject1 = h.FhQ;
    if (!h.cameraCheck(paramContext))
    {
      Log.i("Finder.ActivityRouter", "enterFinderPostRouterUI cameraCheck false!");
      AppMethodBeat.o(330596);
      return;
    }
    localObject1 = paramIntent;
    if (paramIntent == null) {
      localObject1 = new Intent();
    }
    if ((paramContext instanceof AppCompatActivity))
    {
      paramIntent = (AppCompatActivity)paramContext;
      if (paramIntent != null)
      {
        paramIntent = k.aeZF;
        paramIntent = ((as)k.d((AppCompatActivity)paramContext).q(as.class)).zIO;
        if (paramIntent != null) {
          break label290;
        }
        paramIntent = "";
        label101:
        Object localObject2 = k.aeZF;
        String str = ((as)k.d((AppCompatActivity)paramContext).q(as.class)).sessionId;
        localObject2 = str;
        if (str == null) {
          localObject2 = "";
        }
        ((Intent)localObject1).putExtra("key_finder_context_id", paramIntent);
        ((Intent)localObject1).putExtra("key_finder_session_id", (String)localObject2);
      }
      if ((paramContext instanceof Activity)) {
        break label293;
      }
    }
    label290:
    label293:
    for (paramIntent = (Intent)localObject1;; paramIntent = null)
    {
      if (paramIntent != null) {
        paramIntent.addFlags(268435456);
      }
      ((Intent)localObject1).addFlags(67108864);
      ((Intent)localObject1).setClass(paramContext, FinderPostRouterUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/publish/PublishRouterApi", "enterFinderPostRouterUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/publish/PublishRouterApi", "enterFinderPostRouterUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).overridePendingTransition(l.a.push_up_in, l.a.anim_not_change);
      }
      AppMethodBeat.o(330596);
      return;
      paramIntent = null;
      break;
      break label101;
    }
  }
  
  public final void enterFinderPostUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(330641);
    s.u(paramContext, "context");
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (!(paramContext instanceof Activity))
    {
      paramIntent = localIntent;
      if (paramIntent != null) {
        paramIntent.addFlags(268435456);
      }
      localIntent.addFlags(67108864);
      localIntent.setClass(paramContext, FinderPostUI.class);
      paramIntent = paramContext.getSystemService("activity");
      if (!(paramIntent instanceof ActivityManager)) {
        break label228;
      }
      paramIntent = (ActivityManager)paramIntent;
      label82:
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getRunningTasks(1);
        if (paramIntent != null)
        {
          paramIntent = (ActivityManager.RunningTaskInfo)p.oL(paramIntent);
          if (paramIntent != null)
          {
            paramIntent = paramIntent.baseActivity;
            if (paramIntent != null)
            {
              paramIntent = paramContext.getPackageManager().getActivityInfo(paramIntent, 128);
              if (paramIntent != null) {
                break label233;
              }
            }
          }
        }
      }
    }
    label228:
    label233:
    for (paramIntent = null;; paramIntent = paramIntent.taskAffinity)
    {
      if (s.p(paramIntent, "com.tencent.mm.wxcustomentry")) {
        localIntent.setClass(paramContext, FinderPostTransitUI.class);
      }
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/finder/publish/PublishRouterApi", "enterFinderPostUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/finder/publish/PublishRouterApi", "enterFinderPostUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(330641);
      return;
      paramIntent = null;
      break;
      paramIntent = null;
      break label82;
    }
  }
  
  public final void m(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(330635);
    s.u(paramActivity, "context");
    if (paramIntent == null)
    {
      AppMethodBeat.o(330635);
      return;
    }
    paramIntent.putExtra("key_finder_post_router", 17);
    paramIntent.putExtra("key_finder_post_from", 7);
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.GfO;
    com.tencent.mm.plugin.finder.utils.a.enterFinderPostRouterUI((Context)paramActivity, paramIntent);
    AppMethodBeat.o(330635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.publish.i
 * JD-Core Version:    0.7.0.1
 */