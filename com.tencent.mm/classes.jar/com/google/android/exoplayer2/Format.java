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
  private int aFj;
  public final String aSa;
  public final Metadata aSb;
  public final String aSc;
  public final String aSd;
  public final int aSe;
  public final List<byte[]> aSf;
  public final DrmInitData aSg;
  public final float aSh;
  public final int aSi;
  public final float aSj;
  public final int aSk;
  public final byte[] aSl;
  public final ColorInfo aSm;
  public final int aSp;
  public final int aSq;
  public final long aSr;
  public final int aSs;
  public final String aSt;
  public final int aSu;
  public final int bitrate;
  public final int channelCount;
  public final int height;
  public final String id;
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
    this.aSc = paramParcel.readString();
    this.aSd = paramParcel.readString();
    this.aSa = paramParcel.readString();
    this.bitrate = paramParcel.readInt();
    this.aSe = paramParcel.readInt();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.aSh = paramParcel.readFloat();
    this.aSi = paramParcel.readInt();
    this.aSj = paramParcel.readFloat();
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
      this.aSl = arrayOfByte;
      this.aSk = paramParcel.readInt();
      this.aSm = ((ColorInfo)paramParcel.readParcelable(ColorInfo.class.getClassLoader()));
      this.channelCount = paramParcel.readInt();
      this.sampleRate = paramParcel.readInt();
      this.pcmEncoding = paramParcel.readInt();
      this.aSp = paramParcel.readInt();
      this.aSq = paramParcel.readInt();
      this.aSs = paramParcel.readInt();
      this.aSt = paramParcel.readString();
      this.aSu = paramParcel.readInt();
      this.aSr = paramParcel.readLong();
      int j = paramParcel.readInt();
      this.aSf = new ArrayList(j);
      i = 0;
      while (i < j)
      {
        this.aSf.add(paramParcel.createByteArray());
        i += 1;
      }
      i = 0;
      break;
    }
    this.aSg = ((DrmInitData)paramParcel.readParcelable(DrmInitData.class.getClassLoader()));
    this.aSb = ((Metadata)paramParcel.readParcelable(Metadata.class.getClassLoader()));
    AppMethodBeat.o(92334);
  }
  
  public Format(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, int paramInt5, float paramFloat2, byte[] paramArrayOfByte, int paramInt6, ColorInfo paramColorInfo, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, String paramString5, int paramInt13, long paramLong, List<byte[]> paramList, DrmInitData paramDrmInitData, Metadata paramMetadata)
  {
    AppMethodBeat.i(92333);
    this.id = paramString1;
    this.aSc = paramString2;
    this.aSd = paramString3;
    this.aSa = paramString4;
    this.bitrate = paramInt1;
    this.aSe = paramInt2;
    this.width = paramInt3;
    this.height = paramInt4;
    this.aSh = paramFloat1;
    this.aSi = paramInt5;
    this.aSj = paramFloat2;
    this.aSl = paramArrayOfByte;
    this.aSk = paramInt6;
    this.aSm = paramColorInfo;
    this.channelCount = paramInt7;
    this.sampleRate = paramInt8;
    this.pcmEncoding = paramInt9;
    this.aSp = paramInt10;
    this.aSq = paramInt11;
    this.aSs = paramInt12;
    this.aSt = paramString5;
    this.aSu = paramInt13;
    this.aSr = paramLong;
    paramString1 = paramList;
    if (paramList == null) {
      paramString1 = Collections.emptyList();
    }
    this.aSf = paramString1;
    this.aSg = paramDrmInitData;
    this.aSb = paramMetadata;
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
  
  public static Format a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4)
  {
    AppMethodBeat.i(92322);
    paramString1 = a(paramString1, paramString2, paramString3, null, paramInt1, paramInt2, paramString4, -1);
    AppMethodBeat.o(92322);
    return paramString1;
  }
  
  public static Format a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, float paramFloat, List<byte[]> paramList, int paramInt4)
  {
    AppMethodBeat.i(92315);
    paramString1 = new Format(paramString1, paramString2, paramString3, paramString4, paramInt1, -1, paramInt2, paramInt3, paramFloat, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, paramInt4, null, -1, 9223372036854775807L, paramList, null, null);
    AppMethodBeat.o(92315);
    return paramString1;
  }
  
  public static Format a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, List<byte[]> paramList, int paramInt4, String paramString5)
  {
    AppMethodBeat.i(92318);
    paramString1 = new Format(paramString1, paramString2, paramString3, paramString4, paramInt1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, paramInt2, paramInt3, -1, -1, -1, paramInt4, paramString5, -1, 9223372036854775807L, paramList, null, null);
    AppMethodBeat.o(92318);
    return paramString1;
  }
  
  public static Format a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String paramString5)
  {
    AppMethodBeat.i(92330);
    paramString1 = new Format(paramString1, paramString2, paramString3, paramString4, paramInt1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, paramInt2, paramString5, -1, 9223372036854775807L, null, null, null);
    AppMethodBeat.o(92330);
    return paramString1;
  }
  
  public static Format a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String paramString5, int paramInt3)
  {
    AppMethodBeat.i(92323);
    paramString1 = new Format(paramString1, paramString2, paramString3, paramString4, paramInt1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, paramInt2, paramString5, paramInt3, 9223372036854775807L, null, null, null);
    AppMethodBeat.o(92323);
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
    localStringBuilder.append("id=").append(paramFormat.id).append(", mimeType=").append(paramFormat.aSd);
    if (paramFormat.bitrate != -1) {
      localStringBuilder.append(", bitrate=").append(paramFormat.bitrate);
    }
    if ((paramFormat.width != -1) && (paramFormat.height != -1)) {
      localStringBuilder.append(", res=").append(paramFormat.width).append("x").append(paramFormat.height);
    }
    if (paramFormat.aSh != -1.0F) {
      localStringBuilder.append(", fps=").append(paramFormat.aSh);
    }
    if (paramFormat.channelCount != -1) {
      localStringBuilder.append(", channels=").append(paramFormat.channelCount);
    }
    if (paramFormat.sampleRate != -1) {
      localStringBuilder.append(", sample_rate=").append(paramFormat.sampleRate);
    }
    if (paramFormat.aSt != null) {
      localStringBuilder.append(", language=").append(paramFormat.aSt);
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
  
  public static Format c(String paramString, long paramLong)
  {
    AppMethodBeat.i(92331);
    paramString = new Format(null, null, paramString, null, -1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, paramLong, null, null, null);
    AppMethodBeat.o(92331);
    return paramString;
  }
  
  public static Format h(String paramString1, String paramString2)
  {
    AppMethodBeat.i(92324);
    paramString1 = a(paramString1, paramString2, 0, null, null);
    AppMethodBeat.o(92324);
    return paramString1;
  }
  
  public static Format j(String paramString1, String paramString2)
  {
    AppMethodBeat.i(92332);
    paramString1 = new Format(paramString1, null, paramString2, null, -1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, 9223372036854775807L, null, null, null);
    AppMethodBeat.o(92332);
    return paramString1;
  }
  
  public final Format B(long paramLong)
  {
    AppMethodBeat.i(92336);
    Format localFormat = new Format(this.id, this.aSc, this.aSd, this.aSa, this.bitrate, this.aSe, this.width, this.height, this.aSh, this.aSi, this.aSj, this.aSl, this.aSk, this.aSm, this.channelCount, this.sampleRate, this.pcmEncoding, this.aSp, this.aSq, this.aSs, this.aSt, this.aSu, paramLong, this.aSf, this.aSg, this.aSb);
    AppMethodBeat.o(92336);
    return localFormat;
  }
  
  public final Format a(DrmInitData paramDrmInitData)
  {
    AppMethodBeat.i(92339);
    paramDrmInitData = new Format(this.id, this.aSc, this.aSd, this.aSa, this.bitrate, this.aSe, this.width, this.height, this.aSh, this.aSi, this.aSj, this.aSl, this.aSk, this.aSm, this.channelCount, this.sampleRate, this.pcmEncoding, this.aSp, this.aSq, this.aSs, this.aSt, this.aSu, this.aSr, this.aSf, paramDrmInitData, this.aSb);
    AppMethodBeat.o(92339);
    return paramDrmInitData;
  }
  
  public final Format a(Metadata paramMetadata)
  {
    AppMethodBeat.i(92340);
    paramMetadata = new Format(this.id, this.aSc, this.aSd, this.aSa, this.bitrate, this.aSe, this.width, this.height, this.aSh, this.aSi, this.aSj, this.aSl, this.aSk, this.aSm, this.channelCount, this.sampleRate, this.pcmEncoding, this.aSp, this.aSq, this.aSs, this.aSt, this.aSu, this.aSr, this.aSf, this.aSg, paramMetadata);
    AppMethodBeat.o(92340);
    return paramMetadata;
  }
  
  public final Format a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString3)
  {
    AppMethodBeat.i(92337);
    paramString1 = new Format(paramString1, this.aSc, this.aSd, paramString2, paramInt1, this.aSe, paramInt2, paramInt3, this.aSh, this.aSi, this.aSj, this.aSl, this.aSk, this.aSm, this.channelCount, this.sampleRate, this.pcmEncoding, this.aSp, this.aSq, paramInt4, paramString3, this.aSu, this.aSr, this.aSf, this.aSg, this.aSb);
    AppMethodBeat.o(92337);
    return paramString1;
  }
  
  public final Format bc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(92338);
    Format localFormat = new Format(this.id, this.aSc, this.aSd, this.aSa, this.bitrate, this.aSe, this.width, this.height, this.aSh, this.aSi, this.aSj, this.aSl, this.aSk, this.aSm, this.channelCount, this.sampleRate, this.pcmEncoding, paramInt1, paramInt2, this.aSs, this.aSt, this.aSu, this.aSr, this.aSf, this.aSg, this.aSb);
    AppMethodBeat.o(92338);
    return localFormat;
  }
  
  public final Format dH(int paramInt)
  {
    AppMethodBeat.i(92335);
    Format localFormat = new Format(this.id, this.aSc, this.aSd, this.aSa, this.bitrate, paramInt, this.width, this.height, this.aSh, this.aSi, this.aSj, this.aSl, this.aSk, this.aSm, this.channelCount, this.sampleRate, this.pcmEncoding, this.aSp, this.aSq, this.aSs, this.aSt, this.aSu, this.aSr, this.aSf, this.aSg, this.aSb);
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
    if ((this.bitrate != paramObject.bitrate) || (this.aSe != paramObject.aSe) || (this.width != paramObject.width) || (this.height != paramObject.height) || (this.aSh != paramObject.aSh) || (this.aSi != paramObject.aSi) || (this.aSj != paramObject.aSj) || (this.aSk != paramObject.aSk) || (this.channelCount != paramObject.channelCount) || (this.sampleRate != paramObject.sampleRate) || (this.pcmEncoding != paramObject.pcmEncoding) || (this.aSp != paramObject.aSp) || (this.aSq != paramObject.aSq) || (this.aSr != paramObject.aSr) || (this.aSs != paramObject.aSs) || (!x.g(this.id, paramObject.id)) || (!x.g(this.aSt, paramObject.aSt)) || (this.aSu != paramObject.aSu) || (!x.g(this.aSc, paramObject.aSc)) || (!x.g(this.aSd, paramObject.aSd)) || (!x.g(this.aSa, paramObject.aSa)) || (!x.g(this.aSg, paramObject.aSg)) || (!x.g(this.aSb, paramObject.aSb)) || (!x.g(this.aSm, paramObject.aSm)) || (!Arrays.equals(this.aSl, paramObject.aSl)) || (this.aSf.size() != paramObject.aSf.size()))
    {
      AppMethodBeat.o(92344);
      return false;
    }
    int i = 0;
    while (i < this.aSf.size())
    {
      if (!Arrays.equals((byte[])this.aSf.get(i), (byte[])paramObject.aSf.get(i)))
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
    if (this.aFj == 0)
    {
      if (this.id != null) {
        break label208;
      }
      i = 0;
      if (this.aSc != null) {
        break label219;
      }
      j = 0;
      if (this.aSd != null) {
        break label230;
      }
      k = 0;
      if (this.aSa != null) {
        break label241;
      }
      m = 0;
      i3 = this.bitrate;
      i4 = this.width;
      i5 = this.height;
      i6 = this.channelCount;
      i7 = this.sampleRate;
      if (this.aSt != null) {
        break label253;
      }
      n = 0;
      i8 = this.aSu;
      if (this.aSg != null) {
        break label265;
      }
      i1 = 0;
      label109:
      if (this.aSb != null) {
        break label277;
      }
    }
    for (;;)
    {
      this.aFj = ((i1 + ((n + ((((((m + (k + (j + (i + 527) * 31) * 31) * 31) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31) * 31 + i8) * 31) * 31 + i2);
      i = this.aFj;
      AppMethodBeat.o(92343);
      return i;
      label208:
      i = this.id.hashCode();
      break;
      label219:
      j = this.aSc.hashCode();
      break label34;
      label230:
      k = this.aSd.hashCode();
      break label43;
      label241:
      m = this.aSa.hashCode();
      break label53;
      label253:
      n = this.aSt.hashCode();
      break label93;
      label265:
      i1 = this.aSg.hashCode();
      break label109;
      label277:
      i2 = this.aSb.hashCode();
    }
  }
  
  public final int rG()
  {
    if ((this.width == -1) || (this.height == -1)) {
      return -1;
    }
    return this.width * this.height;
  }
  
  @SuppressLint({"InlinedApi"})
  @TargetApi(16)
  public final MediaFormat rH()
  {
    AppMethodBeat.i(92341);
    MediaFormat localMediaFormat = new MediaFormat();
    localMediaFormat.setString("mime", this.aSd);
    Object localObject = this.aSt;
    if (localObject != null) {
      localMediaFormat.setString("language", (String)localObject);
    }
    a(localMediaFormat, "max-input-size", this.aSe);
    a(localMediaFormat, "width", this.width);
    a(localMediaFormat, "height", this.height);
    float f = this.aSh;
    if (f != -1.0F) {
      localMediaFormat.setFloat("frame-rate", f);
    }
    a(localMediaFormat, "rotation-degrees", this.aSi);
    a(localMediaFormat, "channel-count", this.channelCount);
    a(localMediaFormat, "sample-rate", this.sampleRate);
    a(localMediaFormat, "encoder-delay", this.aSp);
    a(localMediaFormat, "encoder-padding", this.aSq);
    int i = 0;
    while (i < this.aSf.size())
    {
      localMediaFormat.setByteBuffer("csd-".concat(String.valueOf(i)), ByteBuffer.wrap((byte[])this.aSf.get(i)));
      i += 1;
    }
    localObject = this.aSm;
    if (localObject != null)
    {
      a(localMediaFormat, "color-transfer", ((ColorInfo)localObject).aYV);
      a(localMediaFormat, "color-standard", ((ColorInfo)localObject).aYU);
      a(localMediaFormat, "color-range", ((ColorInfo)localObject).aYW);
      localObject = ((ColorInfo)localObject).bzA;
      if (localObject != null) {
        localMediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap((byte[])localObject));
      }
    }
    AppMethodBeat.o(92341);
    return localMediaFormat;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(92342);
    String str = "Format(" + this.id + ", " + this.aSc + ", " + this.aSd + ", " + this.bitrate + ", " + this.aSt + ", [" + this.width + ", " + this.height + ", " + this.aSh + "], [" + this.channelCount + ", " + this.sampleRate + "])";
    AppMethodBeat.o(92342);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(92347);
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.aSc);
    paramParcel.writeString(this.aSd);
    paramParcel.writeString(this.aSa);
    paramParcel.writeInt(this.bitrate);
    paramParcel.writeInt(this.aSe);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    paramParcel.writeFloat(this.aSh);
    paramParcel.writeInt(this.aSi);
    paramParcel.writeFloat(this.aSj);
    if (this.aSl != null) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeInt(i);
      if (this.aSl != null) {
        paramParcel.writeByteArray(this.aSl);
      }
      paramParcel.writeInt(this.aSk);
      paramParcel.writeParcelable(this.aSm, paramInt);
      paramParcel.writeInt(this.channelCount);
      paramParcel.writeInt(this.sampleRate);
      paramParcel.writeInt(this.pcmEncoding);
      paramParcel.writeInt(this.aSp);
      paramParcel.writeInt(this.aSq);
      paramParcel.writeInt(this.aSs);
      paramParcel.writeString(this.aSt);
      paramParcel.writeInt(this.aSu);
      paramParcel.writeLong(this.aSr);
      i = this.aSf.size();
      paramParcel.writeInt(i);
      paramInt = 0;
      while (paramInt < i)
      {
        paramParcel.writeByteArray((byte[])this.aSf.get(paramInt));
        paramInt += 1;
      }
    }
    paramParcel.writeParcelable(this.aSg, 0);
    paramParcel.writeParcelable(this.aSb, 0);
    AppMethodBeat.o(92347);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.Format
 * JD-Core Version:    0.7.0.1
 */