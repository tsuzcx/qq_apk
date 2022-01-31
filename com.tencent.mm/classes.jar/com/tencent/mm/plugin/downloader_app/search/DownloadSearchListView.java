package com.tencent.mm.plugin.downloader_app.search;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.downloader.b.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

public class DownloadSearchListView
  extends MRecyclerView
{
  private a.b lbA;
  a lbx;
  List<b> lby;
  List<b> lbz;
  Context mContext;
  
  public DownloadSearchListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(136174);
    this.lbA = new DownloadSearchListView.1(this);
    this.mContext = paramContext;
    AppMethodBeat.o(136174);
  }
  
  public DownloadSearchListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(136175);
    this.lbA = new DownloadSearchListView.1(this);
    this.mContext = paramContext;
    AppMethodBeat.o(136175);
  }
  
  public final void Kd(String paramString)
  {
    AppMethodBeat.i(136179);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(136179);
      return;
    }
    b.ak(this.mContext, paramString);
    this.lby = b.dI(this.mContext);
    AppMethodBeat.o(136179);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(136176);
    ab.i("MicroMsg.DownloadSearchListView", "onAttachedToWindow");
    super.onAttachedToWindow();
    com.tencent.mm.plugin.downloader.b.a.a(this.lbA);
    AppMethodBeat.o(136176);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(136177);
    ab.i("MicroMsg.DownloadSearchListView", "onDetachedFromWindow");
    super.onDetachedFromWindow();
    com.tencent.mm.plugin.downloader.b.a.b(this.lbA);
    AppMethodBeat.o(136177);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(136178);
    super.onFinishInflate();
    getContext();
    setLayoutManager(new LinearLayoutManager());
    this.lbx = new a(this.mContext, this);
    setAdapter(this.lbx);
    a(new c(getResources()));
    this.lby = b.dI(this.mContext);
    this.lbz = new ArrayList();
    AppMethodBeat.o(136178);
  }
  
  void setData(List<b> paramList)
  {
    AppMethodBeat.i(136180);
    a locala = this.lbx;
    locala.iVH.clear();
    if (!bo.es(paramList)) {
      locala.iVH.addAll(paramList);
    }
    locala.ajb.notifyChanged();
    AppMethodBeat.o(136180);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.search.DownloadSearchListView
 * JD-Core Version:    0.7.0.1
 */