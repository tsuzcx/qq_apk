package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

@SafeParcelable.Class(creator="PasswordSpecificationCreator")
@SafeParcelable.Reserved({1000})
public final class PasswordSpecification
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<PasswordSpecification> CREATOR;
  public static final PasswordSpecification zzdg;
  private static final PasswordSpecification zzdh;
  @SafeParcelable.Field(id=1)
  private final String zzdi;
  @SafeParcelable.Field(id=2)
  private final List<String> zzdj;
  @SafeParcelable.Field(id=3)
  private final List<Integer> zzdk;
  @SafeParcelable.Field(id=4)
  private final int zzdl;
  @SafeParcelable.Field(id=5)
  private final int zzdm;
  private final int[] zzdn;
  private final Random zzdo;
  
  static
  {
    AppMethodBeat.i(88260);
    CREATOR = new zzm();
    zzdg = new zzd().zzd(12, 16).zze("abcdefghijkmnopqrstxyzABCDEFGHJKLMNPQRSTXY3456789").zzd("abcdefghijkmnopqrstxyz", 1).zzd("ABCDEFGHJKLMNPQRSTXY", 1).zzd("3456789", 1).zzj();
    zzdh = new zzd().zzd(12, 16).zze("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890").zzd("abcdefghijklmnopqrstuvwxyz", 1).zzd("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 1).zzd("1234567890", 1).zzj();
    AppMethodBeat.o(88260);
  }
  
  @SafeParcelable.Constructor
  PasswordSpecification(@SafeParcelable.Param(id=1) String paramString, @SafeParcelable.Param(id=2) List<String> paramList, @SafeParcelable.Param(id=3) List<Integer> paramList1, @SafeParcelable.Param(id=4) int paramInt1, @SafeParcelable.Param(id=5) int paramInt2)
  {
    AppMethodBeat.i(88255);
    this.zzdi = paramString;
    this.zzdj = Collections.unmodifiableList(paramList);
    this.zzdk = Collections.unmodifiableList(paramList1);
    this.zzdl = paramInt1;
    this.zzdm = paramInt2;
    paramString = new int[95];
    Arrays.fill(paramString, -1);
    paramList = this.zzdj.iterator();
    paramInt1 = 0;
    while (paramList.hasNext())
    {
      paramList1 = ((String)paramList.next()).toCharArray();
      int i = paramList1.length;
      paramInt2 = 0;
      while (paramInt2 < i)
      {
        paramString[(paramList1[paramInt2] - ' ')] = paramInt1;
        paramInt2 += 1;
      }
      paramInt1 += 1;
    }
    this.zzdn = paramString;
    this.zzdo = new SecureRandom();
    AppMethodBeat.o(88255);
  }
  
  private static String zzd(Collection<Character> paramCollection)
  {
    AppMethodBeat.i(88257);
    char[] arrayOfChar = new char[paramCollection.size()];
    paramCollection = paramCollection.iterator();
    int i = 0;
    while (paramCollection.hasNext())
    {
      arrayOfChar[i] = ((Character)paramCollection.next()).charValue();
      i += 1;
    }
    paramCollection = new String(arrayOfChar);
    AppMethodBeat.o(88257);
    return paramCollection;
  }
  
  private static boolean zzd(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt1 < 32) || (paramInt1 > 126);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(88256);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, this.zzdi, false);
    SafeParcelWriter.writeStringList(paramParcel, 2, this.zzdj, false);
    SafeParcelWriter.writeIntegerList(paramParcel, 3, this.zzdk, false);
    SafeParcelWriter.writeInt(paramParcel, 4, this.zzdl);
    SafeParcelWriter.writeInt(paramParcel, 5, this.zzdm);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(88256);
  }
  
  public static final class zzd
  {
    private final List<String> zzdj;
    private final List<Integer> zzdk;
    private int zzdl;
    private int zzdm;
    private final TreeSet<Character> zzdp;
    
    public zzd()
    {
      AppMethodBeat.i(88250);
      this.zzdp = new TreeSet();
      this.zzdj = new ArrayList();
      this.zzdk = new ArrayList();
      this.zzdl = 12;
      this.zzdm = 16;
      AppMethodBeat.o(88250);
    }
    
    private static TreeSet<Character> zzd(String paramString1, String paramString2)
    {
      AppMethodBeat.i(88254);
      if (TextUtils.isEmpty(paramString1))
      {
        paramString1 = new PasswordSpecification.zze(String.valueOf(paramString2).concat(" cannot be null or empty"));
        AppMethodBeat.o(88254);
        throw paramString1;
      }
      TreeSet localTreeSet = new TreeSet();
      paramString1 = paramString1.toCharArray();
      int j = paramString1.length;
      int i = 0;
      while (i < j)
      {
        char c = paramString1[i];
        if (PasswordSpecification.zze(c, 32, 126))
        {
          paramString1 = new PasswordSpecification.zze(String.valueOf(paramString2).concat(" must only contain ASCII printable characters"));
          AppMethodBeat.o(88254);
          throw paramString1;
        }
        localTreeSet.add(Character.valueOf(c));
        i += 1;
      }
      AppMethodBeat.o(88254);
      return localTreeSet;
    }
    
    public final zzd zzd(int paramInt1, int paramInt2)
    {
      this.zzdl = 12;
      this.zzdm = 16;
      return this;
    }
    
    public final zzd zzd(String paramString, int paramInt)
    {
      AppMethodBeat.i(88252);
      paramString = zzd(paramString, "requiredChars");
      this.zzdj.add(PasswordSpecification.zze(paramString));
      this.zzdk.add(Integer.valueOf(1));
      AppMethodBeat.o(88252);
      return this;
    }
    
    public final zzd zze(String paramString)
    {
      AppMethodBeat.i(88251);
      this.zzdp.addAll(zzd(paramString, "allowedChars"));
      AppMethodBeat.o(88251);
      return this;
    }
    
    public final PasswordSpecification zzj()
    {
      AppMethodBeat.i(88253);
      if (this.zzdp.isEmpty())
      {
        localObject = new PasswordSpecification.zze("no allowed characters specified");
        AppMethodBeat.o(88253);
        throw ((Throwable)localObject);
      }
      Object localObject = this.zzdk.iterator();
      for (int i = 0; ((Iterator)localObject).hasNext(); i = ((Integer)((Iterator)localObject).next()).intValue() + i) {}
      if (i > this.zzdm)
      {
        localObject = new PasswordSpecification.zze("required character count cannot be greater than the max password size");
        AppMethodBeat.o(88253);
        throw ((Throwable)localObject);
      }
      localObject = new boolean[95];
      Iterator localIterator = this.zzdj.iterator();
      while (localIterator.hasNext())
      {
        char[] arrayOfChar = ((String)localIterator.next()).toCharArray();
        int j = arrayOfChar.length;
        i = 0;
        while (i < j)
        {
          char c = arrayOfChar[i];
          if (localObject[(c - ' ')] != 0)
          {
            localObject = new PasswordSpecification.zze(58 + "character " + c + " occurs in more than one required character set");
            AppMethodBeat.o(88253);
            throw ((Throwable)localObject);
          }
          localObject[(c - ' ')] = 1;
          i += 1;
        }
      }
      localObject = new PasswordSpecification(PasswordSpecification.zze(this.zzdp), this.zzdj, this.zzdk, this.zzdl, this.zzdm);
      AppMethodBeat.o(88253);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.auth.api.credentials.PasswordSpecification
 * JD-Core Version:    0.7.0.1
 */