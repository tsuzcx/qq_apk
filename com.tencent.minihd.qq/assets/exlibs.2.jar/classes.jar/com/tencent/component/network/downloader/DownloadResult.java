package com.tencent.component.network.downloader;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.component.network.utils.AssertUtil;
import cty;

public final class DownloadResult
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new cty();
  private DownloadReport jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloadReport;
  private DownloadResult.Content jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloadResult$Content = new DownloadResult.Content();
  private DownloadResult.Process jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloadResult$Process = new DownloadResult.Process();
  private DownloadResult.Status jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloadResult$Status = new DownloadResult.Status();
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  private String d;
  
  public DownloadResult(Parcel paramParcel)
  {
    if (paramParcel == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloadResult$Status = ((DownloadResult.Status)paramParcel.readParcelable(DownloadResult.Status.class.getClassLoader()));
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloadResult$Process = ((DownloadResult.Process)paramParcel.readParcelable(DownloadResult.Process.class.getClassLoader()));
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloadResult$Content = ((DownloadResult.Content)paramParcel.readParcelable(DownloadResult.Content.class.getClassLoader()));
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
  }
  
  public DownloadResult(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      AssertUtil.a(bool);
      this.jdField_a_of_type_JavaLangString = paramString;
      return;
    }
  }
  
  public DownloadReport a()
  {
    return this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloadReport;
  }
  
  public DownloadResult.Content a()
  {
    return this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloadResult$Content;
  }
  
  public DownloadResult.Process a()
  {
    return this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloadResult$Process;
  }
  
  public DownloadResult.Status a()
  {
    return this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloadResult$Status;
  }
  
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloadResult$Status.a();
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloadResult$Process.a();
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloadResult$Content.a();
  }
  
  public final void a(DownloadReport paramDownloadReport)
  {
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloadReport = paramDownloadReport;
  }
  
  public final void a(String paramString)
  {
    this.b = paramString;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public final void b(String paramString)
  {
    this.c = paramString;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public final void c(String paramString)
  {
    this.d = paramString;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (paramParcel == null) {
      return;
    }
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloadResult$Status, 0);
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloadResult$Process, 0);
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloadResult$Content, 0);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.DownloadResult
 * JD-Core Version:    0.7.0.1
 */