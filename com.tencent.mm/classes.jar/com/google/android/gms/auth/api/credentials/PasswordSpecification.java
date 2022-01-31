package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public final class PasswordSpecification
  extends zza
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<PasswordSpecification> CREATOR = new zzf();
  public static final PasswordSpecification zzajC = new PasswordSpecification.zza().zzm(12, 16).zzcs("abcdefghijkmnopqrstxyzABCDEFGHJKLMNPQRSTXY3456789").zzf("abcdefghijkmnopqrstxyz", 1).zzf("ABCDEFGHJKLMNPQRSTXY", 1).zzf("3456789", 1).zzqZ();
  public static final PasswordSpecification zzajD = new PasswordSpecification.zza().zzm(12, 16).zzcs("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890").zzf("abcdefghijklmnopqrstuvwxyz", 1).zzf("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 1).zzf("1234567890", 1).zzqZ();
  final int zzaiI;
  final String zzajE;
  final List<String> zzajF;
  final List<Integer> zzajG;
  final int zzajH;
  final int zzajI;
  private final int[] zzajJ;
  private final Random zzzW;
  
  PasswordSpecification(int paramInt1, String paramString, List<String> paramList, List<Integer> paramList1, int paramInt2, int paramInt3)
  {
    this.zzaiI = paramInt1;
    this.zzajE = paramString;
    this.zzajF = Collections.unmodifiableList(paramList);
    this.zzajG = Collections.unmodifiableList(paramList1);
    this.zzajH = paramInt2;
    this.zzajI = paramInt3;
    this.zzajJ = zzqY();
    this.zzzW = new SecureRandom();
  }
  
  private int zza(char paramChar)
  {
    return paramChar - ' ';
  }
  
  private static String zzb(Collection<Character> paramCollection)
  {
    char[] arrayOfChar = new char[paramCollection.size()];
    paramCollection = paramCollection.iterator();
    int i = 0;
    while (paramCollection.hasNext())
    {
      arrayOfChar[i] = ((Character)paramCollection.next()).charValue();
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  private static boolean zzc(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt1 < paramInt2) || (paramInt1 > paramInt3);
  }
  
  private int[] zzqY()
  {
    int[] arrayOfInt = new int[95];
    Arrays.fill(arrayOfInt, -1);
    Iterator localIterator = this.zzajF.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      char[] arrayOfChar = ((String)localIterator.next()).toCharArray();
      int k = arrayOfChar.length;
      int j = 0;
      while (j < k)
      {
        arrayOfInt[zza(arrayOfChar[j])] = i;
        j += 1;
      }
      i += 1;
    }
    return arrayOfInt;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.auth.api.credentials.PasswordSpecification
 * JD-Core Version:    0.7.0.1
 */