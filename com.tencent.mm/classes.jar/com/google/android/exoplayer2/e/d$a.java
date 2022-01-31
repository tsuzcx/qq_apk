package com.google.android.exoplayer2.e;

import android.text.TextUtils;

final class d$a
{
  public final boolean aFK;
  public final String mimeType;
  
  public d$a(String paramString, boolean paramBoolean)
  {
    this.mimeType = paramString;
    this.aFK = paramBoolean;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (paramObject.getClass() != a.class)) {
        return false;
      }
      paramObject = (a)paramObject;
    } while ((TextUtils.equals(this.mimeType, paramObject.mimeType)) && (this.aFK == paramObject.aFK));
    return false;
  }
  
  public final int hashCode()
  {
    int i;
    if (this.mimeType == null)
    {
      i = 0;
      if (!this.aFK) {
        break label41;
      }
    }
    label41:
    for (int j = 1231;; j = 1237)
    {
      return j + (i + 31) * 31;
      i = this.mimeType.hashCode();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.e.d.a
 * JD-Core Version:    0.7.0.1
 */