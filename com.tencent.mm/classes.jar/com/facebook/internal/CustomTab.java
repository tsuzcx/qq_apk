package com.facebook.internal;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.browser.customtabs.b;
import androidx.browser.customtabs.b.a;
import androidx.core.content.a;
import com.facebook.FacebookSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CustomTab
{
  private Uri uri;
  
  public CustomTab(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(7637);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    this.uri = Utility.buildUri(ServerProtocol.getDialogAuthority(), FacebookSdk.getGraphApiVersion() + "/dialog/" + paramString, localBundle);
    AppMethodBeat.o(7637);
  }
  
  public void openCustomTab(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(7638);
    Object localObject = new b.a();
    if (((b.a)localObject).yr != null) {
      ((b.a)localObject).mIntent.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", ((b.a)localObject).yr);
    }
    if (((b.a)localObject).yt != null) {
      ((b.a)localObject).mIntent.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", ((b.a)localObject).yt);
    }
    ((b.a)localObject).mIntent.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", ((b.a)localObject).yu);
    localObject = new b(((b.a)localObject).mIntent, ((b.a)localObject).ys);
    ((b)localObject).intent.setPackage(paramString);
    ((b)localObject).intent.addFlags(1073741824);
    paramString = this.uri;
    ((b)localObject).intent.setData(paramString);
    a.a(paramActivity, ((b)localObject).intent, ((b)localObject).yq);
    AppMethodBeat.o(7638);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.internal.CustomTab
 * JD-Core Version:    0.7.0.1
 */