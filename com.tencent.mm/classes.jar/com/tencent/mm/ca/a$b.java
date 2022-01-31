package com.tencent.mm.ca;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.ae;

public final class a$b
{
  public static boolean EV(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key", paramInt);
    return ae.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/userinfo/"), "ConfigStorage.getBoolean", null, localBundle).getBoolean("key", false);
  }
  
  public static void YJ(String paramString)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("type", Integer.valueOf(-29414086));
    localContentValues.put("value", paramString);
    ae.getContext().getContentResolver().update(Uri.parse("content://com.tencent.mm.storage.provider.emotion/userinfo/"), localContentValues, null, null);
  }
  
  public static String bb(int paramInt, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key", paramInt);
    return ae.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/userinfo/"), "ConfigStorage.getString", null, localBundle).getString("key", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ca.a.b
 * JD-Core Version:    0.7.0.1
 */