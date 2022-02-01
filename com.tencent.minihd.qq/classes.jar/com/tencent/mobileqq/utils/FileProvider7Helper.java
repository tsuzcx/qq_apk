package com.tencent.mobileqq.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.v4.content.FileProvider;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileProvider7Helper
{
  public static String sAuthority = null;
  public static Boolean sIsTargetThanN = null;
  
  public static String getPathFromUri(Context paramContext, String paramString, List<String> paramList)
  {
    String str = paramString;
    if (isTargetBeyondN(paramContext))
    {
      str = paramString;
      if (paramList != null)
      {
        str = paramString;
        if (paramList.size() > 0) {
          str = paramString.replace(File.separator + (String)paramList.get(0), "");
        }
      }
    }
    return str;
  }
  
  public static String getRealPathFromContentURI(Context paramContext, Uri paramUri)
  {
    Object localObject3 = "";
    Object localObject1 = localObject3;
    if (paramUri != null)
    {
      localObject1 = localObject3;
      if (!"".equals(paramUri.toString()))
      {
        localObject1 = paramUri.getScheme();
        if (!"file".equals(localObject1)) {
          break label47;
        }
        localObject1 = paramUri.getPath();
      }
    }
    for (;;)
    {
      return localObject1;
      label47:
      if ("content".equals(localObject1))
      {
        localObject1 = null;
        localObject3 = null;
        try
        {
          Cursor localCursor = paramContext.getContentResolver().query(paramUri, new String[] { "_data" }, null, null, null);
          localObject3 = localCursor;
          localObject1 = localCursor;
          int i = localCursor.getColumnIndexOrThrow("_data");
          localObject3 = localCursor;
          localObject1 = localCursor;
          String str;
          if (localCursor.getCount() > 0)
          {
            localObject3 = localCursor;
            localObject1 = localCursor;
            localCursor.moveToFirst();
            localObject3 = localCursor;
            localObject1 = localCursor;
            str = localCursor.getString(i);
          }
          for (paramContext = str;; paramContext = "")
          {
            localObject1 = paramContext;
            if (localCursor == null) {
              break;
            }
            localCursor.close();
            return paramContext;
          }
        }
        catch (Exception localException)
        {
          localObject2 = localObject3;
          paramContext = getPathFromUri(paramContext, paramUri.getPath(), paramUri.getPathSegments());
          localObject2 = paramContext;
          return paramContext;
        }
        finally
        {
          Object localObject2;
          if (localObject2 != null) {
            ((Cursor)localObject2).close();
          }
        }
      }
    }
    return paramUri.toString();
  }
  
  public static Uri getUriForFile(Context paramContext, File paramFile)
  {
    if (isTargetBeyondN(paramContext)) {
      return getUriForFile24(paramContext, paramFile);
    }
    return Uri.fromFile(paramFile);
  }
  
  private static Uri getUriForFile24(Context paramContext, File paramFile)
  {
    if (sAuthority == null) {
      sAuthority = paramContext.getApplicationContext().getPackageName() + ".fileprovider";
    }
    return FileProvider.getUriForFile(paramContext, sAuthority, paramFile);
  }
  
  public static void grantPermissions(Context paramContext, Intent paramIntent, Uri paramUri, boolean paramBoolean)
  {
    int i = 1;
    if (paramBoolean) {
      i = 0x1 | 0x2;
    }
    paramIntent.addFlags(i);
    paramIntent = paramContext.getPackageManager().queryIntentActivities(paramIntent, 65536).iterator();
    while (paramIntent.hasNext()) {
      paramContext.grantUriPermission(((ResolveInfo)paramIntent.next()).activityInfo.packageName, paramUri, i);
    }
  }
  
  public static void installApkFile(Context paramContext, String paramString)
  {
    paramContext.startActivity(openApkIntent(paramContext, paramString));
  }
  
  public static void intentCompatForN(Context paramContext, Intent paramIntent)
  {
    if (isTargetBeyondN(paramContext))
    {
      paramIntent.getAction();
      Object localObject1 = paramIntent.getData();
      if ((localObject1 != null) && ("file".equals(((Uri)localObject1).getScheme())))
      {
        paramIntent.setDataAndType(getUriForFile24(paramContext, new File(getRealPathFromContentURI(paramContext, (Uri)localObject1))), paramIntent.getType());
        paramIntent.addFlags(1);
        paramIntent.addFlags(2);
      }
      localObject1 = new String[2];
      localObject1[0] = "output";
      localObject1[1] = "android.intent.extra.STREAM";
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        String str = localObject1[i];
        Object localObject2 = paramIntent.getParcelableExtra(str);
        Object localObject3;
        if ((localObject2 instanceof Uri))
        {
          localObject3 = (Uri)localObject2;
          if ("file".equals(((Uri)localObject3).getScheme()))
          {
            paramIntent.putExtra(str, getUriForFile24(paramContext, new File(getRealPathFromContentURI(paramContext, (Uri)localObject3))));
            paramIntent.addFlags(1);
            paramIntent.addFlags(2);
          }
        }
        if (localObject2 == null)
        {
          localObject3 = paramIntent.getParcelableArrayListExtra(str);
          if (localObject3 != null)
          {
            localObject2 = new ArrayList(((ArrayList)localObject3).size());
            paramIntent.addFlags(1);
            paramIntent.addFlags(2);
            localObject3 = ((ArrayList)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              Object localObject4 = (Parcelable)((Iterator)localObject3).next();
              if ((localObject4 instanceof Uri))
              {
                Uri localUri = (Uri)localObject4;
                if ("file".equals(localUri.getScheme()))
                {
                  localObject4 = getUriForFile24(paramContext, new File(getRealPathFromContentURI(paramContext, localUri)));
                  paramIntent.putExtra(str, (Parcelable)localObject4);
                  ((ArrayList)localObject2).add(localObject4);
                }
                else
                {
                  ((ArrayList)localObject2).add(localObject4);
                }
              }
              else
              {
                ((ArrayList)localObject2).add(localObject4);
              }
            }
            paramIntent.putExtra(str, (Serializable)localObject2);
          }
        }
        i += 1;
      }
    }
  }
  
  public static boolean isTargetBeyondN(Context paramContext)
  {
    if (sIsTargetThanN == null) {
      if ((Build.VERSION.SDK_INT < 24) || (paramContext.getApplicationContext().getApplicationInfo().targetSdkVersion < 24)) {
        break label45;
      }
    }
    label45:
    for (boolean bool = true;; bool = false)
    {
      sIsTargetThanN = Boolean.valueOf(bool);
      return sIsTargetThanN.booleanValue();
    }
  }
  
  public static Intent openApkIntent(Context paramContext, String paramString)
  {
    if (!new File(paramString).exists()) {
      return null;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.setAction("android.intent.action.VIEW");
    setIntentDataAndType(paramContext, localIntent, "application/vnd.android.package-archive", new File(paramString));
    return localIntent;
  }
  
  public static Uri savePhotoToSysAlbum(Context paramContext, File paramFile)
  {
    Intent localIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
    paramFile = Uri.fromFile(paramFile);
    localIntent.setData(paramFile);
    paramContext.sendBroadcast(localIntent);
    return paramFile;
  }
  
  public static Uri savePhotoToSysAlbum(Context paramContext, String paramString)
  {
    return savePhotoToSysAlbum(paramContext, new File(paramString));
  }
  
  public static void setIntentDataAndType(Context paramContext, Intent paramIntent, String paramString, File paramFile)
  {
    if (isTargetBeyondN(paramContext))
    {
      paramIntent.setDataAndType(getUriForFile24(paramContext, paramFile), paramString);
      paramIntent.addFlags(1);
      paramIntent.addFlags(2);
      return;
    }
    paramIntent.setDataAndType(Uri.fromFile(paramFile), paramString);
  }
  
  public static Uri setSystemCapture(Context paramContext, File paramFile, Intent paramIntent)
  {
    paramIntent.setAction("android.media.action.IMAGE_CAPTURE");
    if (isTargetBeyondN(paramContext))
    {
      paramContext = getUriForFile24(paramContext, paramFile);
      paramIntent.addFlags(3);
    }
    for (;;)
    {
      paramIntent.putExtra("output", paramContext);
      paramIntent.putExtra("android.intent.extra.videoQuality", 100);
      return paramContext;
      paramContext = Uri.fromFile(paramFile);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.FileProvider7Helper
 * JD-Core Version:    0.7.0.1
 */