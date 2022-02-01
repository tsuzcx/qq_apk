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
import javax.annotation.concurrent.GuardedBy;

public final class f
{
  private final Context bLf;
  @GuardedBy("this")
  private int bLg;
  @GuardedBy("this")
  private int bLh = 0;
  @GuardedBy("this")
  private String zzbu;
  @GuardedBy("this")
  private String zzbv;
  
  public f(Context paramContext)
  {
    this.bLf = paramContext;
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
    String str = parama.xJ().bKj;
    if (str != null)
    {
      AppMethodBeat.o(4153);
      return str;
    }
    parama = parama.xJ().zzs;
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
  
  private final PackageInfo bO(String paramString)
  {
    AppMethodBeat.i(4159);
    try
    {
      paramString = this.bLf.getPackageManager().getPackageInfo(paramString, 0);
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
      PackageInfo localPackageInfo = bO(this.bLf.getPackageName());
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
  
  public final String yf()
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
  
  public final String yg()
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
  
  public final int yh()
  {
    try
    {
      AppMethodBeat.i(4157);
      if (this.bLg == 0)
      {
        PackageInfo localPackageInfo = bO("com.google.android.gms");
        if (localPackageInfo != null) {
          this.bLg = localPackageInfo.versionCode;
        }
      }
      int i = this.bLg;
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
        if (this.bLh != 0)
        {
          i = this.bLh;
          AppMethodBeat.o(4152);
          return i;
        }
        PackageManager localPackageManager = this.bLf.getPackageManager();
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
        this.bLh = 1;
        i = this.bLh;
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
        this.bLh = 2;
        i = this.bLh;
        AppMethodBeat.o(4152);
      }
    }
    if (PlatformVersion.isAtLeastO()) {}
    for (this.bLh = 2;; this.bLh = 1)
    {
      i = this.bLh;
      AppMethodBeat.o(4152);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.firebase.iid.f
 * JD-Core Version:    0.7.0.1
 */