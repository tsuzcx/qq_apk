package androidx.constraintlayout.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class d
{
  protected f Bd;
  protected f Be;
  protected f Bf;
  protected f Bg;
  protected f Bh;
  protected f Bi;
  protected f Bj;
  protected ArrayList<f> Bk;
  protected int Bl;
  protected int Bm;
  protected float Bn = 0.0F;
  protected boolean Bo;
  protected boolean Bp;
  protected boolean Bq;
  boolean Br;
  private int mOrientation;
  private boolean tL = false;
  
  public d(f paramf, int paramInt, boolean paramBoolean)
  {
    this.Bd = paramf;
    this.mOrientation = paramInt;
    this.tL = paramBoolean;
  }
  
  final void ft()
  {
    boolean bool = true;
    AppMethodBeat.i(229485);
    int k = this.mOrientation * 2;
    Object localObject2 = this.Bd;
    Object localObject1 = this.Bd;
    int i = 0;
    while (i == 0)
    {
      this.Bl += 1;
      ((f)localObject1).Dk[this.mOrientation] = null;
      ((f)localObject1).Dj[this.mOrientation] = null;
      int j;
      if (((f)localObject1).CX != 8)
      {
        if (this.Be == null) {
          this.Be = ((f)localObject1);
        }
        this.Bg = ((f)localObject1);
        if ((localObject1.Cz[this.mOrientation] == f.a.Dq) && ((localObject1.Cb[this.mOrientation] == 0) || (localObject1.Cb[this.mOrientation] == 3) || (localObject1.Cb[this.mOrientation] == 2)))
        {
          this.Bm += 1;
          float f = localObject1.Di[this.mOrientation];
          if (f > 0.0F) {
            this.Bn += localObject1.Di[this.mOrientation];
          }
          j = this.mOrientation;
          if ((((f)localObject1).CX == 8) || (localObject1.Cz[j] != f.a.Dq) || ((localObject1.Cb[j] != 0) && (localObject1.Cb[j] != 3))) {
            break label438;
          }
          j = 1;
          label249:
          if (j != 0)
          {
            if (f >= 0.0F) {
              break label443;
            }
            this.Bo = true;
            if (this.Bk == null) {
              this.Bk = new ArrayList();
            }
            this.Bk.add(localObject1);
          }
          label264:
          if (this.Bi == null) {
            this.Bi = ((f)localObject1);
          }
          if (this.Bj != null) {
            this.Bj.Dj[this.mOrientation] = localObject1;
          }
          this.Bj = ((f)localObject1);
        }
      }
      if (localObject2 != localObject1) {
        ((f)localObject2).Dk[this.mOrientation] = localObject1;
      }
      localObject2 = localObject1.Cx[(k + 1)].Bv;
      Object localObject3;
      if (localObject2 != null)
      {
        localObject3 = ((e)localObject2).Bt;
        if (localObject3.Cx[k].Bv != null)
        {
          localObject2 = localObject3;
          if (localObject3.Cx[k].Bv.Bt == localObject1) {
            break label418;
          }
        }
      }
      for (localObject2 = null;; localObject2 = null)
      {
        label418:
        if (localObject2 == null) {
          break label457;
        }
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        break;
        label438:
        j = 0;
        break label249;
        label443:
        this.Bp = true;
        break label264;
      }
      label457:
      i = 1;
      localObject2 = localObject1;
    }
    this.Bf = ((f)localObject1);
    if ((this.mOrientation == 0) && (this.tL))
    {
      this.Bh = this.Bf;
      if ((!this.Bp) || (!this.Bo)) {
        break label531;
      }
    }
    for (;;)
    {
      this.Bq = bool;
      AppMethodBeat.o(229485);
      return;
      this.Bh = this.Bd;
      break;
      label531:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.constraintlayout.a.a.d
 * JD-Core Version:    0.7.0.1
 */