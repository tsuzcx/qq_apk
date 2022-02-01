package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.video.ColorInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Format
  implements Parcelable
{
  public static final Parcelable.Creator<Format> CREATOR;
  private int aHQ;
  public final int bdA;
  public final byte[] bdB;
  public final ColorInfo bdC;
  public final int bdD;
  public final int bdE;
  public final long bdF;
  public final int bdG;
  public final int bdH;
  public final String bdq;
  public final Metadata bdr;
  public final String bds;
  public final String bdt;
  public final int bdu;
  public final List<byte[]> bdv;
  public final DrmInitData bdw;
  public final float bdx;
  public final int bdy;
  public final float bdz;
  public final int bitrate;
  public final int channelCount;
  public final int height;
  public final String id;
  public final String language;
  public final int pcmEncoding;
  public final int sampleRate;
  public final int width;
  
  static
  {
    AppMethodBeat.i(92348);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(92348);
  }
  
  Format(Parcel paramParcel)
  {
    AppMethodBeat.i(92334);
    this.id = paramParcel.readString();
    this.bds = paramParcel.readString();
    this.bdt = paramParcel.readString();
    this.bdq = paramParcel.readString();
    this.bitrate = paramParcel.readInt();
    this.bdu = paramParcel.readInt();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.bdx = paramParcel.readFloat();
    this.bdy = paramParcel.readInt();
    this.bdz = paramParcel.readFloat();
    int i;
    if (paramParcel.readInt() != 0)
    {
      i = 1;
      if (i == 0) {
        break label268;
      }
    }
    label268:
    for (byte[] arrayOfByte = paramParcel.createByteArray();; arrayOfByte = null)
    {
      this.bdB = arrayOfByte;
      this.bdA = paramParcel.readInt();
      this.bdC = ((ColorInfo)paramParcel.readParcelable(ColorInfo.class.getClassLoader()));
      this.channelCount = paramParcel.readInt();
      this.sampleRate = paramParcel.readInt();
      this.pcmEncoding = paramParcel.readInt();
      this.bdD = paramParcel.readInt();
      this.bdE = paramParcel.readInt();
      this.bdG = paramParcel.readInt();
      this.language = paramParcel.readString();
      this.bdH = paramParcel.readInt();
      this.bdF = paramParcel.readLong();
      int j = paramParcel.readInt();
      this.bdv = new ArrayList(j);
      i = 0;
      while (i < j)
      {
        this.bdv.add(paramParcel.createByteArray());
        i += 1;
      }
      i = 0;
      break;
    }
    this.bdw = ((DrmInitData)paramParcel.readParcelable(DrmInitData.class.getClassLoader()));
    this.bdr = ((Metadata)paramParcel.readParcelable(Metadata.class.getClassLoader()));
    AppMethodBeat.o(92334);
  }
  
  private Format(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, int paramInt5, float paramFloat2, byte[] paramArrayOfByte, int paramInt6, ColorInfo paramColorInfo, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, String paramString5, int paramInt13, long paramLong, List<byte[]> paramList, DrmInitData paramDrmInitData, Metadata paramMetadata)
  {
    AppMethodBeat.i(92333);
    this.id = paramString1;
    this.bds = paramString2;
    this.bdt = paramString3;
    this.bdq = paramString4;
    this.bitrate = paramInt1;
    this.bdu = paramInt2;
    this.width = paramInt3;
    this.height = paramInt4;
    this.bdx = paramFloat1;
    this.bdy = paramInt5;
    this.bdz = paramFloat2;
    this.bdB = paramArrayOfByte;
    this.bdA = paramInt6;
    this.bdC = paramColorInfo;
    this.channelCount = paramInt7;
    this.sampleRate = paramInt8;
    this.pcmEncoding = paramInt9;
    this.bdD = paramInt10;
    this.bdE = paramInt11;
    this.bdG = paramInt12;
    this.language = paramString5;
    this.bdH = paramInt13;
    this.bdF = paramLong;
    paramString1 = paramList;
    if (paramList == null) {
      paramString1 = Collections.emptyList();
    }
    this.bdv = paramString1;
    this.bdw = paramDrmInitData;
    this.bdr = paramMetadata;
    AppMethodBeat.o(92333);
  }
  
  public static Format a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, List<byte[]> paramList, DrmInitData paramDrmInitData, int paramInt8, String paramString3, Metadata paramMetadata)
  {
    AppMethodBeat.i(92321);
    paramString1 = new Format(paramString1, null, paramString2, null, paramInt1, paramInt2, -1, -1, -1.0F, -1, -1.0F, null, -1, null, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramString3, -1, 9223372036854775807L, paramList, paramDrmInitData, paramMetadata);
    AppMethodBeat.o(92321);
    return paramString1;
  }
  
  public static Format a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, List<byte[]> paramList, DrmInitData paramDrmInitData, int paramInt6, String paramString3)
  {
    AppMethodBeat.i(92320);
    paramString1 = a(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, -1, -1, paramList, paramDrmInitData, paramInt6, paramString3, null);
    AppMethodBeat.o(92320);
    return paramString1;
  }
  
  public static Format a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, List<byte[]> paramList, DrmInitData paramDrmInitData, String paramString3)
  {
    AppMethodBeat.i(92319);
    paramString1 = a(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, -1, paramList, paramDrmInitData, 0, paramString3);
    AppMethodBeat.o(92319);
    return paramString1;
  }
  
  public static Format a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, List<byte[]> paramList, int paramInt4, float paramFloat, byte[] paramArrayOfByte, int paramInt5, ColorInfo paramColorInfo, DrmInitData paramDrmInitData)
  {
    AppMethodBeat.i(92317);
    paramString1 = new Format(paramString1, null, paramString2, null, -1, paramInt1, paramInt2, paramInt3, -1.0F, paramInt4, paramFloat, paramArrayOfByte, paramInt5, paramColorInfo, -1, -1, -1, -1, -1, 0, null, -1, 9223372036854775807L, paramList, paramDrmInitData, null);
    AppMethodBeat.o(92317);
    return paramString1;
  }
  
  public static Format a(String paramString1, String paramString2, int paramInt1, int paramInt2, List<byte[]> paramList, float paramFloat)
  {
    AppMethodBeat.i(92316);
    paramString1 = a(paramString1, paramString2, -1, paramInt1, paramInt2, paramList, -1, paramFloat, null, -1, null, null);
    AppMethodBeat.o(92316);
    return paramString1;
  }
  
  public static Format a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(211638);
    paramString1 = new Format(paramString1, paramString2, null, null, -1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, paramInt, paramString3, -1, 9223372036854775807L, null, null, null);
    AppMethodBeat.o(211638);
    return paramString1;
  }
  
  public static Format a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(92326);
    paramString1 = a(paramString1, paramString2, paramInt1, paramString3, paramInt2, null, 9223372036854775807L, Collections.emptyList());
    AppMethodBeat.o(92326);
    return paramString1;
  }
  
  public static Format a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, DrmInitData paramDrmInitData, long paramLong, List<byte[]> paramList)
  {
    AppMethodBeat.i(92328);
    paramString1 = new Format(paramString1, null, paramString2, null, -1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, paramInt1, paramString3, paramInt2, paramLong, paramList, paramDrmInitData, null);
    AppMethodBeat.o(92328);
    return paramString1;
  }
  
  public static Format a(String paramString1, String paramString2, int paramInt, String paramString3, DrmInitData paramDrmInitData)
  {
    AppMethodBeat.i(92325);
    paramString1 = a(paramString1, paramString2, paramInt, paramString3, -1, paramDrmInitData, 9223372036854775807L, Collections.emptyList());
    AppMethodBeat.o(92325);
    return paramString1;
  }
  
  public static Format a(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(92327);
    paramString1 = a(null, paramString1, 0, paramString2, -1, null, paramLong, Collections.emptyList());
    AppMethodBeat.o(92327);
    return paramString1;
  }
  
  public static Format a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(211637);
    paramString1 = new Format(paramString1, paramString2, null, paramString3, paramInt1, -1, paramInt2, paramInt3, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, 9223372036854775807L, null, null, null);
    AppMethodBeat.o(211637);
    return paramString1;
  }
  
  public static Format a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    AppMethodBeat.i(211639);
    paramString1 = a(paramString1, paramString2, paramString3, paramInt, paramString4, -1);
    AppMethodBeat.o(211639);
    return paramString1;
  }
  
  public static Format a(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2)
  {
    AppMethodBeat.i(211640);
    paramString1 = new Format(paramString1, paramString2, paramString3, null, -1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, paramInt1, paramString4, paramInt2, 9223372036854775807L, null, null, null);
    AppMethodBeat.o(211640);
    return paramString1;
  }
  
  public static Format a(String paramString1, String paramString2, List<byte[]> paramList, String paramString3, DrmInitData paramDrmInitData)
  {
    AppMethodBeat.i(92329);
    paramString1 = new Format(paramString1, null, paramString2, null, -1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, 0, paramString3, -1, 9223372036854775807L, paramList, paramDrmInitData, null);
    AppMethodBeat.o(92329);
    return paramString1;
  }
  
  public static String a(Format paramFormat)
  {
    AppMethodBeat.i(92346);
    if (paramFormat == null)
    {
      AppMethodBeat.o(92346);
      return "null";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id=").append(paramFormat.id).append(", mimeType=").append(paramFormat.bdt);
    if (paramFormat.bitrate != -1) {
      localStringBuilder.append(", bitrate=").append(paramFormat.bitrate);
    }
    if ((paramFormat.width != -1) && (paramFormat.height != -1)) {
      localStringBuilder.append(", res=").append(paramFormat.width).append("x").append(paramFormat.height);
    }
    if (paramFormat.bdx != -1.0F) {
      localStringBuilder.append(", fps=").append(paramFormat.bdx);
    }
    if (paramFormat.channelCount != -1) {
      localStringBuilder.append(", channels=").append(paramFormat.channelCount);
    }
    if (paramFormat.sampleRate != -1) {
      localStringBuilder.append(", sample_rate=").append(paramFormat.sampleRate);
    }
    if (paramFormat.language != null) {
      localStringBuilder.append(", language=").append(paramFormat.language);
    }
    paramFormat = localStringBuilder.toString();
    AppMethodBeat.o(92346);
    return paramFormat;
  }
  
  @TargetApi(16)
  private static void a(MediaFormat paramMediaFormat, String paramString, int paramInt)
  {
    AppMethodBeat.i(92345);
    if (paramInt != -1) {
      paramMediaFormat.setInteger(paramString, paramInt);
    }
    AppMethodBeat.o(92345);
  }
  
  public static Format bc(String paramString)
  {
    AppMethodBeat.i(211641);
    paramString = a(null, paramString, 0, null, null);
    AppMethodBeat.o(211641);
    return paramString;
  }
  
  public static Format c(String paramString, long paramLong)
  {
    AppMethodBeat.i(92331);
    paramString = new Format(null, null, paramString, null, -1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, paramLong, null, null, null);
    AppMethodBeat.o(92331);
    return paramString;
  }
  
  public static Format j(String paramString1, String paramString2)
  {
    AppMethodBeat.i(211642);
    paramString1 = new Format(paramString1, paramString2, null, null, -1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, 9223372036854775807L, null, null, null);
    AppMethodBeat.o(211642);
    return paramString1;
  }
  
  public static Format k(String paramString1, String paramString2)
  {
    AppMethodBeat.i(92332);
    paramString1 = new Format(paramString1, null, paramString2, null, -1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, 9223372036854775807L, null, null, null);
    AppMethodBeat.o(92332);
    return paramString1;
  }
  
  public final Format D(long paramLong)
  {
    AppMethodBeat.i(92336);
    Format localFormat = new Format(this.id, this.bds, this.bdt, this.bdq, this.bitrate, this.bdu, this.width, this.height, this.bdx, this.bdy, this.bdz, this.bdB, this.bdA, this.bdC, this.channelCount, this.sampleRate, this.pcmEncoding, this.bdD, this.bdE, this.bdG, this.language, this.bdH, paramLong, this.bdv, this.bdw, this.bdr);
    AppMethodBeat.o(92336);
    return localFormat;
  }
  
  public final Format a(DrmInitData paramDrmInitData)
  {
    AppMethodBeat.i(92339);
    paramDrmInitData = new Format(this.id, this.bds, this.bdt, this.bdq, this.bitrate, this.bdu, this.width, this.height, this.bdx, this.bdy, this.bdz, this.bdB, this.bdA, this.bdC, this.channelCount, this.sampleRate, this.pcmEncoding, this.bdD, this.bdE, this.bdG, this.language, this.bdH, this.bdF, this.bdv, paramDrmInitData, this.bdr);
    AppMethodBeat.o(92339);
    return paramDrmInitData;
  }
  
  public final Format a(Metadata paramMetadata)
  {
    AppMethodBeat.i(92340);
    paramMetadata = new Format(this.id, this.bds, this.bdt, this.bdq, this.bitrate, this.bdu, this.width, this.height, this.bdx, this.bdy, this.bdz, this.bdB, this.bdA, this.bdC, this.channelCount, this.sampleRate, this.pcmEncoding, this.bdD, this.bdE, this.bdG, this.language, this.bdH, this.bdF, this.bdv, this.bdw, paramMetadata);
    AppMethodBeat.o(92340);
    return paramMetadata;
  }
  
  public final Format a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString3)
  {
    AppMethodBeat.i(92337);
    paramString1 = new Format(paramString1, this.bds, this.bdt, paramString2, paramInt1, this.bdu, paramInt2, paramInt3, this.bdx, this.bdy, this.bdz, this.bdB, this.bdA, this.bdC, this.channelCount, this.sampleRate, this.pcmEncoding, this.bdD, this.bdE, paramInt4, paramString3, this.bdH, this.bdF, this.bdv, this.bdw, this.bdr);
    AppMethodBeat.o(92337);
    return paramString1;
  }
  
  public final Format be(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(92338);
    Format localFormat = new Format(this.id, this.bds, this.bdt, this.bdq, this.bitrate, this.bdu, this.width, this.height, this.bdx, this.bdy, this.bdz, this.bdB, this.bdA, this.bdC, this.channelCount, this.sampleRate, this.pcmEncoding, paramInt1, paramInt2, this.bdG, this.language, this.bdH, this.bdF, this.bdv, this.bdw, this.bdr);
    AppMethodBeat.o(92338);
    return localFormat;
  }
  
  public final Format dK(int paramInt)
  {
    AppMethodBeat.i(92335);
    Format localFormat = new Format(this.id, this.bds, this.bdt, this.bdq, this.bitrate, paramInt, this.width, this.height, this.bdx, this.bdy, this.bdz, this.bdB, this.bdA, this.bdC, this.channelCount, this.sampleRate, this.pcmEncoding, this.bdD, this.bdE, this.bdG, this.language, this.bdH, this.bdF, this.bdv, this.bdw, this.bdr);
    AppMethodBeat.o(92335);
    return localFormat;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(92344);
    if (this == paramObject)
    {
      AppMethodBeat.o(92344);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(92344);
      return false;
    }
    paramObject = (Format)paramObject;
    if ((this.bitrate != paramObject.bitrate) || (this.bdu != paramObject.bdu) || (this.width != paramObject.width) || (this.height != paramObject.height) || (this.bdx != paramObject.bdx) || (this.bdy != paramObject.bdy) || (this.bdz != paramObject.bdz) || (this.bdA != paramObject.bdA) || (this.channelCount != paramObject.channelCount) || (this.sampleRate != paramObject.sampleRate) || (this.pcmEncoding != paramObject.pcmEncoding) || (this.bdD != paramObject.bdD) || (this.bdE != paramObject.bdE) || (this.bdF != paramObject.bdF) || (this.bdG != paramObject.bdG) || (!x.i(this.id, paramObject.id)) || (!x.i(this.language, paramObject.language)) || (this.bdH != paramObject.bdH) || (!x.i(this.bds, paramObject.bds)) || (!x.i(this.bdt, paramObject.bdt)) || (!x.i(this.bdq, paramObject.bdq)) || (!x.i(this.bdw, paramObject.bdw)) || (!x.i(this.bdr, paramObject.bdr)) || (!x.i(this.bdC, paramObject.bdC)) || (!Arrays.equals(this.bdB, paramObject.bdB)) || (this.bdv.size() != paramObject.bdv.size()))
    {
      AppMethodBeat.o(92344);
      return false;
    }
    int i = 0;
    while (i < this.bdv.size())
    {
      if (!Arrays.equals((byte[])this.bdv.get(i), (byte[])paramObject.bdv.get(i)))
      {
        AppMethodBeat.o(92344);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(92344);
    return true;
  }
  
  public final int hashCode()
  {
    int i2 = 0;
    AppMethodBeat.i(92343);
    int i;
    int j;
    label34:
    int k;
    label43:
    int m;
    label53:
    int i3;
    int i4;
    int i5;
    int i6;
    int i7;
    int n;
    label93:
    int i8;
    int i1;
    if (this.aHQ == 0)
    {
      if (this.id != null) {
        break label208;
      }
      i = 0;
      if (this.bds != null) {
        break label219;
      }
      j = 0;
      if (this.bdt != null) {
        break label230;
      }
      k = 0;
      if (this.bdq != null) {
        break label241;
      }
      m = 0;
      i3 = this.bitrate;
      i4 = this.width;
      i5 = this.height;
      i6 = this.channelCount;
      i7 = this.sampleRate;
      if (this.language != null) {
        break label253;
      }
      n = 0;
      i8 = this.bdH;
      if (this.bdw != null) {
        break label265;
      }
      i1 = 0;
      label109:
      if (this.bdr != null) {
        break label277;
      }
    }
    for (;;)
    {
      this.aHQ = ((i1 + ((n + ((((((m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31) * 31 + i8) * 31) * 31 + i2);
      i = this.aHQ;
      AppMethodBeat.o(92343);
      return i;
      label208:
      i = this.id.hashCode();
      break;
      label219:
      j = this.bds.hashCode();
      break label34;
      label230:
      k = this.bdt.hashCode();
      break label43;
      label241:
      m = this.bdq.hashCode();
      break label53;
      label253:
      n = this.language.hashCode();
      break label93;
      label265:
      i1 = this.bdw.hashCode();
      break label109;
      label277:
      i2 = this.bdr.hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(92342);
    String str = "Format(" + this.id + ", " + this.bds + ", " + this.bdt + ", " + this.bitrate + ", " + this.language + ", [" + this.width + ", " + this.height + ", " + this.bdx + "], [" + this.channelCount + ", " + this.sampleRate + "])";
    AppMethodBeat.o(92342);
    return str;
  }
  
  public final int tq()
  {
    if ((this.width == -1) || (this.height == -1)) {
      return -1;
    }
    return this.width * this.height;
  }
  
  @SuppressLint({"InlinedApi"})
  @TargetApi(16)
  public final MediaFormat tr()
  {
    AppMethodBeat.i(92341);
    MediaFormat localMediaFormat = new MediaFormat();
    localMediaFormat.setString("mime", this.bdt);
    Object localObject = this.language;
    if (localObject != null) {
      localMediaFormat.setString("language", (String)localObject);
    }
    a(localMediaFormat, "max-input-size", this.bdu);
    a(localMediaFormat, "width", this.width);
    a(localMediaFormat, "height", this.height);
    float f = this.bdx;
    if (f != -1.0F) {
      localMediaFormat.setFloat("frame-rate", f);
    }
    a(localMediaFormat, "rotation-degrees", this.bdy);
    a(localMediaFormat, "channel-count", this.channelCount);
    a(localMediaFormat, "sample-rate", this.sampleRate);
    a(localMediaFormat, "encoder-delay", this.bdD);
    a(localMediaFormat, "encoder-padding", this.bdE);
    int i = 0;
    while (i < this.bdv.size())
    {
      localMediaFormat.setByteBuffer("csd-".concat(String.valueOf(i)), ByteBuffer.wrap((byte[])this.bdv.get(i)));
      i += 1;
    }
    localObject = this.bdC;
    if (localObject != null)
    {
      a(localMediaFormat, "color-transfer", ((ColorInfo)localObject).bkc);
      a(localMediaFormat, "color-standard", ((ColorInfo)localObject).bkb);
      a(localMediaFormat, "color-range", ((ColorInfo)localObject).bkd);
      localObject = ((ColorInfo)localObject).bHw;
      if (localObject != null) {
        localMediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap((byte[])localObject));
      }
    }
    AppMethodBeat.o(92341);
    return localMediaFormat;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(92347);
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.bds);
    paramParcel.writeString(this.bdt);
    paramParcel.writeString(this.bdq);
    paramParcel.writeInt(this.bitrate);
    paramParcel.writeInt(this.bdu);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    paramParcel.writeFloat(this.bdx);
    paramParcel.writeInt(this.bdy);
    paramParcel.writeFloat(this.bdz);
    if (this.bdB != null) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeInt(i);
      if (this.bdB != null) {
        paramParcel.writeByteArray(this.bdB);
      }
      paramParcel.writeInt(this.bdA);
      paramParcel.writeParcelable(this.bdC, paramInt);
      paramParcel.writeInt(this.channelCount);
      paramParcel.writeInt(this.sampleRate);
      paramParcel.writeInt(this.pcmEncoding);
      paramParcel.writeInt(this.bdD);
      paramParcel.writeInt(this.bdE);
      paramParcel.writeInt(this.bdG);
      paramParcel.writeString(this.language);
      paramParcel.writeInt(this.bdH);
      paramParcel.writeLong(this.bdF);
      i = this.bdv.size();
      paramParcel.writeInt(i);
      paramInt = 0;
      while (paramInt < i)
      {
        paramParcel.writeByteArray((byte[])this.bdv.get(paramInt));
        paramInt += 1;
      }
    }
    paramParcel.writeParcelable(this.bdw, 0);
    paramParcel.writeParcelable(this.bdr, 0);
    AppMethodBeat.o(92347);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.Format
 * JD-Core Version:    0.7.0.1
 */