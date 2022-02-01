package com.facebook.internal;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.b.a;
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
    if (((b.a)localObject).gu != null) {
      ((b.a)localObject).mIntent.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", ((b.a)localObject).gu);
    }
    if (((b.a)localObject).gw != null) {
      ((b.a)localObject).mIntent.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", ((b.a)localObject).gw);
    }
    ((b.a)localObject).mIntent.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", ((b.a)localObject).gx);
    localObject = new android.support.customtabs.b(((b.a)localObject).mIntent, ((b.a)localObject).gv, (byte)0);
    ((android.support.customtabs.b)localObject).intent.setPackage(paramString);
    ((android.support.customtabs.b)localObject).intent.addFlags(1073741824);
    paramString = this.uri;
    ((android.support.customtabs.b)localObject).intent.setData(paramString);
    android.support.v4.content.b.startActivity(paramActivity, ((android.support.customtabs.b)localObject).intent, ((android.support.customtabs.b)localObject).gt);
    AppMethodBeat.o(7638);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.internal.CustomTab
 * JD-Core Version:    0.7.0.1
 */