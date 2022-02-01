package androidx.transition;

import android.view.View;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ChangeTransform$c
{
  final float ceS;
  final float ceT;
  final float ceU;
  final float ceV;
  final float ceW;
  final float ceX;
  final float ceY;
  final float ceZ;
  
  ChangeTransform$c(View paramView)
  {
    AppMethodBeat.i(201380);
    this.ceS = paramView.getTranslationX();
    this.ceT = paramView.getTranslationY();
    this.ceU = z.ah(paramView);
    this.ceV = paramView.getScaleX();
    this.ceW = paramView.getScaleY();
    this.ceX = paramView.getRotationX();
    this.ceY = paramView.getRotationY();
    this.ceZ = paramView.getRotation();
    AppMethodBeat.o(201380);
  }
  
  public final void bV(View paramView)
  {
    AppMethodBeat.i(201387);
    ChangeTransform.a(paramView, this.ceS, this.ceT, this.ceU, this.ceV, this.ceW, this.ceX, this.ceY, this.ceZ);
    AppMethodBeat.o(201387);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof c)) {}
    do
    {
      return false;
      paramObject = (c)paramObject;
    } while ((paramObject.ceS != this.ceS) || (paramObject.ceT != this.ceT) || (paramObject.ceU != this.ceU) || (paramObject.ceV != this.ceV) || (paramObject.ceW != this.ceW) || (paramObject.ceX != this.ceX) || (paramObject.ceY != this.ceY) || (paramObject.ceZ != this.ceZ));
    return true;
  }
  
  public final int hashCode()
  {
    int i3 = 0;
    AppMethodBeat.i(201404);
    int i;
    int j;
    label42:
    int k;
    label59:
    int m;
    label77:
    int n;
    label95:
    int i1;
    if (this.ceS != 0.0F)
    {
      i = Float.floatToIntBits(this.ceS);
      if (this.ceT == 0.0F) {
        break label201;
      }
      j = Float.floatToIntBits(this.ceT);
      if (this.ceU == 0.0F) {
        break label206;
      }
      k = Float.floatToIntBits(this.ceU);
      if (this.ceV == 0.0F) {
        break label211;
      }
      m = Float.floatToIntBits(this.ceV);
      if (this.ceW == 0.0F) {
        break label217;
      }
      n = Float.floatToIntBits(this.ceW);
      if (this.ceX == 0.0F) {
        break label223;
      }
      i1 = Float.floatToIntBits(this.ceX);
      label113:
      if (this.ceY == 0.0F) {
        break label229;
      }
    }
    label201:
    label206:
    label211:
    label217:
    label223:
    label229:
    for (int i2 = Float.floatToIntBits(this.ceY);; i2 = 0)
    {
      if (this.ceZ != 0.0F) {
        i3 = Float.floatToIntBits(this.ceZ);
      }
      AppMethodBeat.o(201404);
      return (i2 + (i1 + (n + (m + (k + (j + i * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i3;
      i = 0;
      break;
      j = 0;
      break label42;
      k = 0;
      break label59;
      m = 0;
      break label77;
      n = 0;
      break label95;
      i1 = 0;
      break label113;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.transition.ChangeTransform.c
 * JD-Core Version:    0.7.0.1
 */