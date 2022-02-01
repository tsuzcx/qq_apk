package com.tencent.mm.plugin.flutter.voip.flutterplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.c.j.i;
import com.tencent.c.j.o;
import com.tencent.c.j.q;
import com.tencent.c.j.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.flutter.voip.c.b;
import com.tencent.mm.plugin.setting.ui.setting.SettingsAboutCamera;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI;
import com.tencent.mm.sdk.platformtools.Log;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/voip/flutterplugin/FlutterRouterPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lcom/tencent/pigeon/VoIPFlutterPluginApi$RouterPluginApi;", "Lio/flutter/embedding/engine/plugins/activity/ActivityAware;", "()V", "activity", "Landroid/app/Activity;", "launchDoubleLinkSettings", "", "launchFileSelector", "result", "Lcom/tencent/pigeon/VoIPFlutterPluginApi$Result;", "Lcom/tencent/pigeon/VoIPFlutterPluginApi$VirtualBgInfo;", "launchFinderFeed", "request", "Lcom/tencent/pigeon/VoIPFlutterPluginApi$FinderFeedLaunchRequest;", "launchFinderSelector", "launchSnsPost", "Lcom/tencent/pigeon/VoIPFlutterPluginApi$SnsPostLaunchRequest;", "launchUserProfile", "Lcom/tencent/pigeon/VoIPFlutterPluginApi$UserProfileLaunchRequest;", "onAttachedToActivity", "binding", "Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;", "onAttachedToEngine", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromActivity", "onDetachedFromActivityForConfigChanges", "onDetachedFromEngine", "onReattachedToActivityForConfigChanges", "Companion", "plugin-flutter-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends j.o
  implements FlutterPlugin, ActivityAware
{
  public static final a.a HmU;
  private Activity activity;
  
  static
  {
    AppMethodBeat.i(263438);
    HmU = new a.a((byte)0);
    AppMethodBeat.o(263438);
  }
  
  public final void a(j.i parami)
  {
    AppMethodBeat.i(263516);
    s.u(parami, "request");
    Log.i("MicroMsg.FlutterRouterPlugin", "launchFinderFeed(" + parami.hJU + ", " + parami.nonceId + ')');
    Activity localActivity = this.activity;
    if (localActivity == null)
    {
      AppMethodBeat.o(263516);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("from_user", z.bAM());
    Long localLong = parami.hJU;
    s.s(localLong, "request.feedId");
    localIntent.putExtra("feed_object_id", ((Number)localLong).longValue());
    localIntent.putExtra("feed_object_nonceId", parami.nonceId);
    localIntent.putExtra("key_session_id", com.tencent.mm.model.cn.bDu());
    localIntent.putExtra("key_comment_scene", 25);
    ((com.tencent.mm.plugin.findersdk.a.cn)h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).fillContextIdToIntent(33, 2, 25, localIntent);
    localIntent.putExtra("key_extra_info", "");
    parami = com.tencent.mm.plugin.finder.utils.a.GfO;
    com.tencent.mm.plugin.finder.utils.a.Y((Context)localActivity, localIntent);
    AppMethodBeat.o(263516);
  }
  
  public final void a(j.q paramq)
  {
    AppMethodBeat.i(263496);
    s.u(paramq, "request");
    Log.i("MicroMsg.FlutterRouterPlugin", "launchUserProfile(" + paramq.username + ", " + paramq.hHB + ')');
    Activity localActivity = this.activity;
    if (localActivity == null)
    {
      AppMethodBeat.o(263496);
      return;
    }
    Intent localIntent = new Intent((Context)localActivity, SnsCommentDetailUI.class);
    localIntent.putExtra("INTENT_TALKER", paramq.username);
    localIntent.putExtra("INTENT_SNS_LOCAL_ID", paramq.hHB);
    localIntent.putExtra("INTENT_FROMGALLERY", true);
    com.tencent.mm.hellhoundlib.a.a.a(localActivity, c.a(1, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent).aYi(), "com/tencent/mm/plugin/flutter/voip/flutterplugin/FlutterRouterPlugin", "launchSnsPost", "(Lcom/tencent/pigeon/VoIPFlutterPluginApi$SnsPostLaunchRequest;)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    AppMethodBeat.o(263496);
  }
  
  public final void a(j.t paramt)
  {
    AppMethodBeat.i(263507);
    s.u(paramt, "request");
    Log.i("MicroMsg.FlutterRouterPlugin", "launchUserProfile(" + paramt.username + ')');
    Activity localActivity = this.activity;
    if (localActivity == null)
    {
      AppMethodBeat.o(263507);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClass((Context)localActivity, Class.forName("com.tencent.mm.plugin.profile.ui.ContactInfoUI"));
    localIntent.putExtra("Contact_User", paramt.username);
    paramt = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(localActivity, paramt.aYi(), "com/tencent/mm/plugin/flutter/voip/flutterplugin/FlutterRouterPlugin", "launchUserProfile", "(Lcom/tencent/pigeon/VoIPFlutterPluginApi$UserProfileLaunchRequest;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localActivity.startActivity((Intent)paramt.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localActivity, "com/tencent/mm/plugin/flutter/voip/flutterplugin/FlutterRouterPlugin", "launchUserProfile", "(Lcom/tencent/pigeon/VoIPFlutterPluginApi$UserProfileLaunchRequest;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(263507);
  }
  
  public final void fvl()
  {
    AppMethodBeat.i(263487);
    Log.i("MicroMsg.FlutterRouterPlugin", "launchDoubleLinkSettings()");
    Activity localActivity = this.activity;
    if (localActivity == null)
    {
      AppMethodBeat.o(263487);
      return;
    }
    Object localObject = new Intent((Context)localActivity, SettingsAboutCamera.class);
    ((Intent)localObject).putExtra("activity_caller_params", 1);
    ((Intent)localObject).setFlags(268435456);
    localActivity = this.activity;
    if (localActivity != null)
    {
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(localActivity, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/flutter/voip/flutterplugin/FlutterRouterPlugin", "launchDoubleLinkSettings", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localActivity.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localActivity, "com/tencent/mm/plugin/flutter/voip/flutterplugin/FlutterRouterPlugin", "launchDoubleLinkSettings", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(263487);
  }
  
  public final void fvm()
  {
    AppMethodBeat.i(263521);
    Activity localActivity = this.activity;
    if (localActivity != null)
    {
      b localb = b.HnG;
      b.aV(localActivity);
    }
    AppMethodBeat.o(263521);
  }
  
  public final void fvn()
  {
    AppMethodBeat.i(263526);
    Activity localActivity = this.activity;
    if (localActivity != null)
    {
      b localb = b.HnG;
      b.aW(localActivity);
    }
    AppMethodBeat.o(263526);
  }
  
  public final void onAttachedToActivity(ActivityPluginBinding paramActivityPluginBinding)
  {
    AppMethodBeat.i(263459);
    s.u(paramActivityPluginBinding, "binding");
    this.activity = paramActivityPluginBinding.getActivity();
    AppMethodBeat.o(263459);
  }
  
  public final void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(263447);
    s.u(paramFlutterPluginBinding, "binding");
    j.o.a(paramFlutterPluginBinding.getBinaryMessenger(), (j.o)this);
    AppMethodBeat.o(263447);
  }
  
  public final void onDetachedFromActivity()
  {
    this.activity = null;
  }
  
  public final void onDetachedFromActivityForConfigChanges()
  {
    this.activity = null;
  }
  
  public final void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(263453);
    s.u(paramFlutterPluginBinding, "binding");
    AppMethodBeat.o(263453);
  }
  
  public final void onReattachedToActivityForConfigChanges(ActivityPluginBinding paramActivityPluginBinding)
  {
    AppMethodBeat.i(263467);
    s.u(paramActivityPluginBinding, "binding");
    this.activity = paramActivityPluginBinding.getActivity();
    AppMethodBeat.o(263467);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.voip.flutterplugin.a
 * JD-Core Version:    0.7.0.1
 */