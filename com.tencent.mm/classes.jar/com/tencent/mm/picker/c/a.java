package com.tencent.mm.picker.c;

import android.content.Context;
import android.graphics.Typeface;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.a.g;
import com.tencent.mm.picker.base.view.WheelView.b;
import com.tencent.mm.picker.d.c;
import com.tencent.mm.picker.d.d;
import com.tencent.mm.picker.d.e;
import java.util.Calendar;

public final class a
{
  public static com.tencent.mm.picker.base.c.b mBV;
  public Typeface bDt;
  public int bwU;
  public boolean bxO;
  public Context context;
  public int endYear;
  public ViewGroup gR;
  public String label;
  public int layoutRes;
  public c mBW;
  public e mBX;
  public d mBY;
  public com.tencent.mm.picker.d.b mBZ;
  public boolean mBq;
  public int mBx;
  public WheelView.b mCA;
  public boolean mCa;
  public boolean mCb;
  public boolean[] mCc;
  public Calendar mCd;
  public Calendar mCe;
  public Calendar mCf;
  public String mCg;
  public String mCh;
  public String mCi;
  public String mCj;
  public String mCk;
  public String mCl;
  public int mCm;
  public String mCn;
  public String mCo;
  public String mCp;
  public int mCq;
  public int mCr;
  public int mCs;
  public int mCt;
  public int mCu;
  public int mCv;
  public int mCw;
  public int mCx;
  public float mCy;
  public boolean mCz;
  public int option;
  public int startYear;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(175332);
    this.mCa = false;
    this.mCb = false;
    this.mCc = new boolean[] { 1, 1, 1, 0, 0, 0 };
    this.mCm = 17;
    this.mCq = -15028967;
    this.mCr = -1979711488;
    this.mCs = -16777216;
    this.mCt = -1;
    this.mCu = -657931;
    this.mCv = 24;
    this.mCw = 24;
    this.mBx = 0;
    this.mCx = -1;
    this.mCy = 1.6F;
    this.bxO = true;
    this.mBq = false;
    this.bDt = Typeface.DEFAULT;
    this.mCA = WheelView.b.mBR;
    this.bwU = 0;
    if (paramInt == 1)
    {
      this.layoutRes = a.g.mm_pickerview_options;
      AppMethodBeat.o(175332);
      return;
    }
    this.layoutRes = a.g.mm_pickerview_time;
    AppMethodBeat.o(175332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.picker.c.a
 * JD-Core Version:    0.7.0.1
 */