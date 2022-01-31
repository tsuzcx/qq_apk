package com.tencent.mm.plugin.downloader.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.c.a.a.d;
import com.tencent.mm.plugin.downloader.c.b.b;
import com.tencent.mm.plugin.downloader.c.b.f;
import com.tencent.mm.plugin.downloader.c.b.j;
import com.tencent.mm.sdk.platformtools.ab;

class DownloadChecker$DownloadInterceptBean
  implements Parcelable
{
  public static final Parcelable.Creator<DownloadInterceptBean> CREATOR;
  public String appId;
  public String appName;
  public boolean cmX;
  public String cqq;
  public int cvQ;
  public String downloadUrl;
  public String iconUrl;
  public int kXO;
  public String kXP;
  public String kXQ;
  public boolean kXR;
  public String packageName;
  public long size;
  
  static
  {
    AppMethodBeat.i(2349);
    CREATOR = new DownloadChecker.DownloadInterceptBean.1();
    AppMethodBeat.o(2349);
  }
  
  public DownloadChecker$DownloadInterceptBean() {}
  
  private DownloadChecker$DownloadInterceptBean(Parcel paramParcel)
  {
    AppMethodBeat.i(2346);
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.cmX = bool1;
      this.kXO = paramParcel.readInt();
      this.kXP = paramParcel.readString();
      this.appId = paramParcel.readString();
      this.appName = paramParcel.readString();
      this.iconUrl = paramParcel.readString();
      this.downloadUrl = paramParcel.readString();
      this.kXQ = paramParcel.readString();
      this.size = paramParcel.readLong();
      this.packageName = paramParcel.readString();
      this.cqq = paramParcel.readString();
      this.cvQ = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label141;
      }
    }
    label141:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.kXR = bool1;
      AppMethodBeat.o(2346);
      return;
      bool1 = false;
      break;
    }
  }
  
  static boolean a(d paramd)
  {
    AppMethodBeat.i(2348);
    if ((paramd == null) || (paramd.kVQ == null) || (paramd.kVQ.kWX == null) || (paramd.kVQ.kWX.kWM == null) || (!URLUtil.isNetworkUrl(paramd.kVQ.kWX.kWM.eds)))
    {
      ab.i("MicroMsg.DownloadChecker", "downloadInfo is invalid");
      AppMethodBeat.o(2348);
      return false;
    }
    AppMethodBeat.o(2348);
    return true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(2347);
    if (this.cmX)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.kXO);
      paramParcel.writeString(this.kXP);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.appName);
      paramParcel.writeString(this.iconUrl);
      paramParcel.writeString(this.downloadUrl);
      paramParcel.writeString(this.kXQ);
      paramParcel.writeLong(this.size);
      paramParcel.writeString(this.packageName);
      paramParcel.writeString(this.cqq);
      paramParcel.writeInt(this.cvQ);
      if (!this.kXR) {
        break label137;
      }
    }
    label137:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(2347);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.DownloadChecker.DownloadInterceptBean
 * JD-Core Version:    0.7.0.1
 */