package com.tencent.mm.picker.c;

import android.content.Context;
import android.graphics.Typeface;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.view.WheelView.b;
import com.tencent.mm.picker.d.c;
import com.tencent.mm.picker.d.d;
import com.tencent.mm.picker.d.e;
import java.util.Calendar;

public final class a
{
  public static com.tencent.mm.picker.base.c.b jKQ;
  public ViewGroup Zv;
  public Context context;
  public int endYear;
  public c jKR;
  public e jKS;
  public d jKT;
  public com.tencent.mm.picker.d.b jKU;
  public boolean jKV;
  public boolean jKW;
  public boolean[] jKX;
  public Calendar jKY;
  public Calendar jKZ;
  public boolean jKn;
  public int jKu;
  public Calendar jLa;
  public String jLb;
  public String jLc;
  public String jLd;
  public String jLe;
  public String jLf;
  public String jLg;
  public int jLh;
  public int jLi;
  public String jLj;
  public String jLk;
  public String jLl;
  public int jLm;
  public int jLn;
  public int jLo;
  public int jLp;
  public int jLq;
  public int jLr;
  public int jLs;
  public int jLt;
  public float jLu;
  public boolean jLv;
  public WheelView.b jLw;
  public int kn;
  public Typeface lC;
  public String label;
  public int option;
  public boolean ox;
  public int startYear;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(175332);
    this.jKV = false;
    this.jKW = false;
    this.jKX = new boolean[] { 1, 1, 1, 0, 0, 0 };
    this.jLi = 17;
    this.jLm = -15028967;
    this.jLn = -1979711488;
    this.jLo = -16777216;
    this.jLp = -1;
    this.jLq = -657931;
    this.jLr = 24;
    this.jLs = 24;
    this.jKu = 0;
    this.jLt = -1;
    this.jLu = 1.6F;
    this.ox = true;
    this.jKn = false;
    this.lC = Typeface.DEFAULT;
    this.jLw = WheelView.b.jKM;
    this.kn = 0;
    if (paramInt == 1)
    {
      this.jLh = 2131495930;
      AppMethodBeat.o(175332);
      return;
    }
    this.jLh = 2131495932;
    AppMethodBeat.o(175332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.picker.c.a
 * JD-Core Version:    0.7.0.1
 */