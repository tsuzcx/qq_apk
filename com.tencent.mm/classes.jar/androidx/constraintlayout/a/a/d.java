package androidx.constraintlayout.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class d
{
  protected f bhl;
  protected f bhm;
  protected f bhn;
  protected f bho;
  protected f bhp;
  protected f bhq;
  protected f bhr;
  protected ArrayList<f> bhs;
  protected int bht;
  protected int bhu;
  protected float bhv = 0.0F;
  protected boolean bhw;
  protected boolean bhx;
  protected boolean bhy;
  boolean bhz;
  private int mOrientation;
  private boolean uK = false;
  
  public d(f paramf, int paramInt, boolean paramBoolean)
  {
    this.bhl = paramf;
    this.mOrientation = paramInt;
    this.uK = paramBoolean;
  }
  
  final void CC()
  {
    boolean bool = true;
    AppMethodBeat.i(194037);
    int k = this.mOrientation * 2;
    Object localObject2 = this.bhl;
    Object localObject1 = this.bhl;
    int i = 0;
    while (i == 0)
    {
      this.bht += 1;
      ((f)localObject1).bjs[this.mOrientation] = null;
      ((f)localObject1).bjr[this.mOrientation] = null;
      int j;
      if (((f)localObject1).bje != 8)
      {
        if (this.bhm == null) {
          this.bhm = ((f)localObject1);
        }
        this.bho = ((f)localObject1);
        if ((localObject1.biH[this.mOrientation] == f.a.bjy) && ((localObject1.bii[this.mOrientation] == 0) || (localObject1.bii[this.mOrientation] == 3) || (localObject1.bii[this.mOrientation] == 2)))
        {
          this.bhu += 1;
          float f = localObject1.bjq[this.mOrientation];
          if (f > 0.0F) {
            this.bhv += localObject1.bjq[this.mOrientation];
          }
          j = this.mOrientation;
          if ((((f)localObject1).bje == 8) || (localObject1.biH[j] != f.a.bjy) || ((localObject1.bii[j] != 0) && (localObject1.bii[j] != 3))) {
            break label438;
          }
          j = 1;
          label249:
          if (j != 0)
          {
            if (f >= 0.0F) {
              break label443;
            }
            this.bhw = true;
            if (this.bhs == null) {
              this.bhs = new ArrayList();
            }
            this.bhs.add(localObject1);
          }
          label264:
          if (this.bhq == null) {
            this.bhq = ((f)localObject1);
          }
          if (this.bhr != null) {
            this.bhr.bjr[this.mOrientation] = localObject1;
          }
          this.bhr = ((f)localObject1);
        }
      }
      if (localObject2 != localObject1) {
        ((f)localObject2).bjs[this.mOrientation] = localObject1;
      }
      localObject2 = localObject1.biF[(k + 1)].bhD;
      Object localObject3;
      if (localObject2 != null)
      {
        localObject3 = ((e)localObject2).bhB;
        if (localObject3.biF[k].bhD != null)
        {
          localObject2 = localObject3;
          if (localObject3.biF[k].bhD.bhB == localObject1) {
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
        this.bhx = true;
        break label264;
      }
      label457:
      i = 1;
      localObject2 = localObject1;
    }
    this.bhn = ((f)localObject1);
    if ((this.mOrientation == 0) && (this.uK))
    {
      this.bhp = this.bhn;
      if ((!this.bhx) || (!this.bhw)) {
        break label531;
      }
    }
    for (;;)
    {
      this.bhy = bool;
      AppMethodBeat.o(194037);
      return;
      this.bhp = this.bhl;
      break;
      label531:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.constraintlayout.a.a.d
 * JD-Core Version:    0.7.0.1
 */