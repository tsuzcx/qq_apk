package com.google.android.gms.auth.api.credentials;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class PasswordSpecification$zza
{
  private final List<String> zzajF = new ArrayList();
  private final List<Integer> zzajG = new ArrayList();
  private int zzajH = 12;
  private int zzajI = 16;
  private final TreeSet<Character> zzajK = new TreeSet();
  
  private void zzra()
  {
    Iterator localIterator = this.zzajG.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((Integer)localIterator.next()).intValue() + i) {}
    if (i > this.zzajI) {
      throw new PasswordSpecification.zzb("required character count cannot be greater than the max password size");
    }
  }
  
  private void zzrb()
  {
    boolean[] arrayOfBoolean = new boolean[95];
    Iterator localIterator = this.zzajF.iterator();
    while (localIterator.hasNext())
    {
      char[] arrayOfChar = ((String)localIterator.next()).toCharArray();
      int j = arrayOfChar.length;
      int i = 0;
      while (i < j)
      {
        char c = arrayOfChar[i];
        if (arrayOfBoolean[(c - ' ')] != 0) {
          throw new PasswordSpecification.zzb(58 + "character " + c + " occurs in more than one required character set");
        }
        arrayOfBoolean[(c - ' ')] = true;
        i += 1;
      }
    }
  }
  
  private TreeSet<Character> zzw(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      throw new PasswordSpecification.zzb(String.valueOf(paramString2).concat(" cannot be null or empty"));
    }
    TreeSet localTreeSet = new TreeSet();
    paramString1 = paramString1.toCharArray();
    int j = paramString1.length;
    int i = 0;
    while (i < j)
    {
      char c = paramString1[i];
      if (PasswordSpecification.zzd(c, 32, 126)) {
        throw new PasswordSpecification.zzb(String.valueOf(paramString2).concat(" must only contain ASCII printable characters"));
      }
      localTreeSet.add(Character.valueOf(c));
      i += 1;
    }
    return localTreeSet;
  }
  
  public zza zzcs(String paramString)
  {
    this.zzajK.addAll(zzw(paramString, "allowedChars"));
    return this;
  }
  
  public zza zzf(String paramString, int paramInt)
  {
    if (paramInt <= 0) {
      throw new PasswordSpecification.zzb("count must be at least 1");
    }
    paramString = zzw(paramString, "requiredChars");
    this.zzajF.add(PasswordSpecification.zzc(paramString));
    this.zzajG.add(Integer.valueOf(paramInt));
    return this;
  }
  
  public zza zzm(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= 0) {
      throw new PasswordSpecification.zzb("minimumSize must be at least 1");
    }
    if (paramInt1 > paramInt2) {
      throw new PasswordSpecification.zzb("maximumSize must be greater than or equal to minimumSize");
    }
    this.zzajH = paramInt1;
    this.zzajI = paramInt2;
    return this;
  }
  
  public PasswordSpecification zzqZ()
  {
    if (this.zzajK.isEmpty()) {
      throw new PasswordSpecification.zzb("no allowed characters specified");
    }
    zzra();
    zzrb();
    return new PasswordSpecification(1, PasswordSpecification.zzc(this.zzajK), this.zzajF, this.zzajG, this.zzajH, this.zzajI);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.auth.api.credentials.PasswordSpecification.zza
 * JD-Core Version:    0.7.0.1
 */