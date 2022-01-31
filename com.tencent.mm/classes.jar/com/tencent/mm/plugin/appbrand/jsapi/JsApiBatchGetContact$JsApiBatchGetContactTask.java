package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;

class JsApiBatchGetContact$JsApiBatchGetContactTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiBatchGetContactTask> CREATOR = new JsApiBatchGetContact.JsApiBatchGetContactTask.2();
  private String aox;
  public ArrayList<String> gfF;
  private i gfG;
  private String gfH;
  private o gfd;
  private int gfg;
  
  public JsApiBatchGetContact$JsApiBatchGetContactTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public JsApiBatchGetContact$JsApiBatchGetContactTask(i parami, o paramo, int paramInt, ArrayList<String> paramArrayList)
  {
    this.gfG = parami;
    this.gfd = paramo;
    this.gfg = paramInt;
    this.gfF = paramArrayList;
  }
  
  public final void Zu()
  {
    e.post(new JsApiBatchGetContact.JsApiBatchGetContactTask.1(this), "AppBrandJsApiBatchGetContact");
  }
  
  public final void Zv()
  {
    if (!bk.bl(this.gfH)) {
      this.gfd.C(this.gfg, this.gfH);
    }
    for (;;)
    {
      ahD();
      return;
      this.gfd.C(this.gfg, this.gfG.h(this.aox, null));
    }
  }
  
  public final void e(Parcel paramParcel)
  {
    this.gfF = paramParcel.readArrayList(getClass().getClassLoader());
    this.gfH = paramParcel.readString();
    this.aox = paramParcel.readString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeList(this.gfF);
    paramParcel.writeString(this.gfH);
    paramParcel.writeString(this.aox);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiBatchGetContact.JsApiBatchGetContactTask
 * JD-Core Version:    0.7.0.1
 */