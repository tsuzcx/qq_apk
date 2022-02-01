package com.dataxad.flutter_mailer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.Html;
import androidx.core.content.FileProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.ActivityResultListener;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

final class b
  implements MethodChannel.MethodCallHandler, PluginRegistry.ActivityResultListener
{
  Activity activity;
  private MethodChannel.Result cBE;
  private final Context context;
  
  b(Context paramContext)
  {
    this.context = paramContext;
    this.activity = null;
  }
  
  private boolean cl(String paramString)
  {
    AppMethodBeat.i(206941);
    try
    {
      this.context.getPackageManager().getPackageInfo(paramString, 0);
      AppMethodBeat.o(206941);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      AppMethodBeat.o(206941);
    }
    return false;
  }
  
  private static String[] e(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(206932);
    int j = paramArrayList.size();
    String[] arrayOfString = new String[j];
    int i = 0;
    while (i < j)
    {
      arrayOfString[i] = ((String)paramArrayList.get(i));
      i += 1;
    }
    AppMethodBeat.o(206932);
    return arrayOfString;
  }
  
  public final boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(206978);
    if ((paramInt1 == 564) && (this.cBE != null))
    {
      this.cBE.success("android");
      AppMethodBeat.o(206978);
      return false;
    }
    AppMethodBeat.o(206978);
    return false;
  }
  
  public final void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    int i = 0;
    AppMethodBeat.i(206971);
    Intent localIntent;
    Object localObject1;
    if (paramMethodCall.method.equals("send"))
    {
      this.cBE = paramResult;
      try
      {
        localIntent = new Intent("android.intent.action.SENDTO", Uri.parse("mailto:"));
        if (!paramMethodCall.hasArgument("subject")) {
          break label75;
        }
        localObject1 = (String)paramMethodCall.argument("subject");
        if (localObject1 == null) {
          break label356;
        }
      }
      catch (a paramMethodCall)
      {
        for (;;)
        {
          paramResult.error(paramMethodCall.cBH, paramMethodCall.cBF, paramMethodCall.cBG);
          this.cBE = null;
          AppMethodBeat.o(206971);
          return;
          localObject1 = "";
          continue;
          localObject1 = Html.fromHtml((String)localObject1);
          break;
          localObject1 = new ArrayList();
        }
      }
      catch (Exception paramMethodCall)
      {
        label75:
        paramMethodCall.getMessage();
        paramResult.error("UNKNOWN", paramMethodCall.getMessage(), null);
        this.cBE = null;
        AppMethodBeat.o(206971);
        return;
      }
      localIntent.putExtra("android.intent.extra.SUBJECT", (String)localObject1);
      if (paramMethodCall.hasArgument("body"))
      {
        localObject1 = (String)paramMethodCall.argument("body");
        if (localObject1 == null) {
          break label833;
        }
      }
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (paramMethodCall.hasArgument("isHTML"))
      {
        localObject2 = localObject1;
        if (((Boolean)paramMethodCall.argument("isHTML")).booleanValue())
        {
          localObject1 = (String)localObject1;
          if (Build.VERSION.SDK_INT < 24) {
            break label363;
          }
          localObject1 = Html.fromHtml((String)localObject1, 0);
          break label826;
        }
      }
      for (;;)
      {
        localIntent.putExtra("android.intent.extra.TEXT", (CharSequence)localObject2);
        if (paramMethodCall.hasArgument("recipients"))
        {
          localObject1 = (ArrayList)paramMethodCall.argument("recipients");
          if (localObject1 != null) {
            localIntent.putExtra("android.intent.extra.EMAIL", e((ArrayList)localObject1));
          }
        }
        else
        {
          if (paramMethodCall.hasArgument("ccRecipients"))
          {
            localObject1 = (ArrayList)paramMethodCall.argument("ccRecipients");
            if (localObject1 == null) {
              break label415;
            }
            localIntent.putExtra("android.intent.extra.CC", e((ArrayList)localObject1));
          }
          if (paramMethodCall.hasArgument("bccRecipients"))
          {
            localObject1 = (ArrayList)paramMethodCall.argument("bccRecipients");
            if (localObject1 == null) {
              break label427;
            }
          }
        }
        for (;;)
        {
          localIntent.putExtra("android.intent.extra.BCC", e((ArrayList)localObject1));
          if (!paramMethodCall.hasArgument("attachments")) {
            break label566;
          }
          localObject1 = (ArrayList)paramMethodCall.argument("attachments");
          if (localObject1 != null) {
            break label439;
          }
          paramMethodCall = new a("Attachments_null", "Attachments cannot be null");
          AppMethodBeat.o(206971);
          throw paramMethodCall;
          label356:
          label363:
          localObject1 = new ArrayList();
          label415:
          break;
          label427:
          localObject1 = new ArrayList();
        }
        label439:
        if (!((ArrayList)localObject1).isEmpty())
        {
          localObject2 = new ArrayList();
          while (i < ((ArrayList)localObject1).size())
          {
            Object localObject3 = (String)((ArrayList)localObject1).get(i);
            localIntent.addFlags(1);
            localObject3 = new File((String)localObject3);
            ((ArrayList)localObject2).add(FileProvider.getUriForFile(this.context, this.context.getPackageName() + ".adv_provider", (File)localObject3));
            i += 1;
          }
          localIntent.setAction("android.intent.action.SEND_MULTIPLE").setType("message/rfc822").putExtra("android.intent.extra.STREAM", (Serializable)localObject2).addFlags(1);
        }
        label566:
        localObject1 = this.context.getPackageManager().queryIntentActivities(localIntent, 0);
        if ((localObject1 == null) || (((List)localObject1).size() == 0))
        {
          paramMethodCall = new a("not_available", "no email Managers available");
          AppMethodBeat.o(206971);
          throw paramMethodCall;
        }
        if ((((List)localObject1).size() != 1) && (paramMethodCall.hasArgument("appSchema")) && (paramMethodCall.argument("appSchema") != null) && (cl((String)paramMethodCall.argument("appSchema")))) {
          localIntent.setPackage((String)paramMethodCall.argument("appSchema"));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this.activity, c.a(564, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent).aYi(), "com/dataxad/flutter_mailer/MethodCallHandlerImpl", "onMethodCall", "(Lio/flutter/plugin/common/MethodCall;Lio/flutter/plugin/common/MethodChannel$Result;)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
        AppMethodBeat.o(206971);
        return;
        if (paramMethodCall.method.equals("isAppInstalled"))
        {
          if ((paramMethodCall.hasArgument("appSchema")) && (paramMethodCall.argument("appSchema") != null) && (cl((String)paramMethodCall.argument("appSchema"))))
          {
            paramResult.success(Boolean.TRUE);
            AppMethodBeat.o(206971);
            return;
          }
          paramResult.success(Boolean.FALSE);
          AppMethodBeat.o(206971);
          return;
        }
        paramResult.notImplemented();
        AppMethodBeat.o(206971);
        return;
        label826:
        localObject2 = localObject1;
      }
      label833:
      localObject1 = "";
    }
  }
  
  static final class a
    extends Exception
  {
    final String cBF;
    final Object cBG;
    final String cBH;
    
    a(String paramString1, String paramString2)
    {
      this.cBH = paramString1;
      this.cBF = paramString2;
      this.cBG = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.dataxad.flutter_mailer.b
 * JD-Core Version:    0.7.0.1
 */