package com.tencent.mm.picker.c;

import android.content.Context;
import android.graphics.Typeface;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.g;
import com.tencent.mm.picker.base.c.b;
import com.tencent.mm.picker.base.view.WheelView.b;
import com.tencent.mm.picker.d.c;
import com.tencent.mm.picker.d.d;
import com.tencent.mm.picker.d.e;
import com.tencent.mm.picker.d.f;
import java.util.Calendar;

public final class a
{
  public static b pyD;
  public float bbg;
  public Context context;
  public int dpX;
  public boolean dqR;
  public Typeface dwu;
  public int endYear;
  public ViewGroup hM;
  public String label;
  public int layoutRes;
  public int option;
  public boolean pxZ;
  public d pyE;
  public f pyF;
  public e pyG;
  public c pyH;
  public boolean pyI;
  public boolean pyJ;
  public boolean[] pyK;
  public Calendar pyL;
  public Calendar pyM;
  public Calendar pyN;
  public String pyO;
  public String pyP;
  public String pyQ;
  public String pyR;
  public String pyS;
  public String pyT;
  public int pyU;
  public String pyV;
  public String pyW;
  public String pyX;
  public int pyY;
  public int pyZ;
  public int pyf;
  public int pza;
  public int pzb;
  public int pzc;
  public int pzd;
  public int pze;
  public int pzf;
  public boolean pzg;
  public WheelView.b pzh;
  public int startYear;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(175332);
    this.pyI = false;
    this.pyJ = false;
    this.pyK = new boolean[] { 1, 1, 1, 0, 0, 0 };
    this.pyU = 17;
    this.pyY = -15028967;
    this.pyZ = -1979711488;
    this.pza = -16777216;
    this.pzb = -1;
    this.pzc = -657931;
    this.pzd = 24;
    this.pze = 24;
    this.pyf = 0;
    this.pzf = -1;
    this.bbg = 1.6F;
    this.dqR = true;
    this.pxZ = false;
    this.dwu = Typeface.DEFAULT;
    this.pzh = WheelView.b.pyz;
    this.dpX = 0;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.picker.c.a
 * JD-Core Version:    0.7.0.1
 */