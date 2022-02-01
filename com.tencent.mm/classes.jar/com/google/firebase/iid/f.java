package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Base64;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.firebase.a;
import com.google.firebase.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.List;

public final class f
{
  private final Context dCI;
  private int dCJ;
  private int dCK = 0;
  private String zzbu;
  private String zzbv;
  
  public f(Context paramContext)
  {
    this.dCI = paramContext;
  }
  
  public static String a(KeyPair paramKeyPair)
  {
    AppMethodBeat.i(4154);
    paramKeyPair = paramKeyPair.getPublic().getEncoded();
    try
    {
      paramKeyPair = MessageDigest.getInstance("SHA1").digest(paramKeyPair);
      paramKeyPair[0] = ((byte)((paramKeyPair[0] & 0xF) + 112));
      paramKeyPair = Base64.encodeToString(paramKeyPair, 0, 8, 11);
      AppMethodBeat.o(4154);
      return paramKeyPair;
    }
    catch (NoSuchAlgorithmException paramKeyPair)
    {
      AppMethodBeat.o(4154);
    }
    return null;
  }
  
  public static String b(a parama)
  {
    AppMethodBeat.i(4153);
    String str = parama.XW().dBM;
    if (str != null)
    {
      AppMethodBeat.o(4153);
      return str;
    }
    parama = parama.XW().zzs;
    if (!parama.startsWith("1:"))
    {
      AppMethodBeat.o(4153);
      return parama;
    }
    parama = parama.split(":");
    if (parama.length < 2)
    {
      AppMethodBeat.o(4153);
      return null;
    }
    parama = parama[1];
    if (parama.isEmpty())
    {
      AppMethodBeat.o(4153);
      return null;
    }
    AppMethodBeat.o(4153);
    return parama;
  }
  
  private final PackageInfo dA(String paramString)
  {
    AppMethodBeat.i(4159);
    try
    {
      paramString = this.dCI.getPackageManager().getPackageInfo(paramString, 0);
      AppMethodBeat.o(4159);
      return paramString;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      paramString = String.valueOf(paramString);
      new StringBuilder(String.valueOf(paramString).length() + 23).append("Failed to find package ").append(paramString);
      AppMethodBeat.o(4159);
    }
    return null;
  }
  
  private final void zzab()
  {
    try
    {
      AppMethodBeat.i(4158);
      PackageInfo localPackageInfo = dA(this.dCI.getPackageName());
      if (localPackageInfo != null)
      {
        this.zzbu = Integer.toString(localPackageInfo.versionCode);
        this.zzbv = localPackageInfo.versionName;
      }
      AppMethodBeat.o(4158);
      return;
    }
    finally {}
  }
  
  public final String Ys()
  {
    try
    {
      AppMethodBeat.i(4155);
      if (this.zzbu == null) {
        zzab();
      }
      String str = this.zzbu;
      AppMethodBeat.o(4155);
      return str;
    }
    finally {}
  }
  
  public final String Yt()
  {
    try
    {
      AppMethodBeat.i(4156);
      if (this.zzbv == null) {
        zzab();
      }
      String str = this.zzbv;
      AppMethodBeat.o(4156);
      return str;
    }
    finally {}
  }
  
  public final int Yu()
  {
    try
    {
      AppMethodBeat.i(4157);
      if (this.dCJ == 0)
      {
        PackageInfo localPackageInfo = dA("com.google.android.gms");
        if (localPackageInfo != null) {
          this.dCJ = localPackageInfo.versionCode;
        }
      }
      int i = this.dCJ;
      AppMethodBeat.o(4157);
      return i;
    }
    finally {}
  }
  
  public final int zzx()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(4152);
        if (this.dCK != 0)
        {
          i = this.dCK;
          AppMethodBeat.o(4152);
          return i;
        }
        PackageManager localPackageManager = this.dCI.getPackageManager();
        if (localPackageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1)
        {
          AppMethodBeat.o(4152);
          continue;
        }
        if (PlatformVersion.isAtLeastO()) {
          break label128;
        }
      }
      finally {}
      Object localObject2 = new Intent("com.google.android.c2dm.intent.REGISTER");
      ((Intent)localObject2).setPackage("com.google.android.gms");
      localObject2 = localObject1.queryIntentServices((Intent)localObject2, 0);
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        this.dCK = 1;
        i = this.dCK;
        AppMethodBeat.o(4152);
      }
      else
      {
        label128:
        localObject2 = new Intent("com.google.iid.TOKEN_REQUEST");
        ((Intent)localObject2).setPackage("com.google.android.gms");
        List localList = localObject1.queryBroadcastReceivers((Intent)localObject2, 0);
        if ((localList == null) || (localList.size() <= 0)) {
          break;
        }
        this.dCK = 2;
        i = this.dCK;
        AppMethodBeat.o(4152);
      }
    }
    if (PlatformVersion.isAtLeastO()) {}
    for (this.dCK = 2;; this.dCK = 1)
    {
      i = this.dCK;
      AppMethodBeat.o(4152);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.firebase.iid.f
 * JD-Core Version:    0.7.0.1
 */