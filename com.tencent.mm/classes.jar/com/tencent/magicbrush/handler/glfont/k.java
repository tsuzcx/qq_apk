package com.tencent.magicbrush.handler.glfont;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class k
  implements c
{
  private int bKA;
  private c.c bKB;
  private c.a bKz;
  private int mHeight;
  private ArrayList<c.b> mNodes;
  private int mWidth;
  
  k()
  {
    AppMethodBeat.i(115956);
    this.mNodes = new ArrayList();
    this.bKz = new c.a();
    this.bKB = new c.c();
    AppMethodBeat.o(115956);
  }
  
  public final void a(int paramInt1, int paramInt2, Rect paramRect)
  {
    AppMethodBeat.i(115958);
    if (paramRect == null)
    {
      AppMethodBeat.o(115958);
      return;
    }
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      paramRect.setEmpty();
      AppMethodBeat.o(115958);
      return;
    }
    c.c localc = this.bKB;
    localc.x = 0;
    localc.y = 0;
    localc.width = paramInt1;
    localc.height = paramInt2;
    int k = -1;
    int i = 0;
    int j = 2147483647;
    int n = 2147483647;
    c.b localb1;
    int m;
    if (i < this.mNodes.size())
    {
      localb1 = (c.b)this.mNodes.get(i);
      if (localb1.x + paramInt1 > this.mWidth - 1)
      {
        m = -1;
        label122:
        if (m < 0) {
          break label758;
        }
        localb1 = (c.b)this.mNodes.get(i);
        if ((m + paramInt2 >= n) && ((m + paramInt2 != n) || (localb1.z <= 0) || (localb1.z >= j))) {
          break label758;
        }
        j = localb1.z;
        localc.x = localb1.x;
        localc.y = m;
        k = i;
        n = m + paramInt2;
      }
    }
    label316:
    label758:
    for (;;)
    {
      i += 1;
      break;
      m = localb1.y;
      int i1 = i;
      int i2 = paramInt1;
      for (;;)
      {
        if (i2 <= 0) {
          break label316;
        }
        localb1 = (c.b)this.mNodes.get(i1);
        int i3 = m;
        if (localb1.y > m) {
          i3 = localb1.y;
        }
        if (i3 + paramInt2 > this.mHeight - 1)
        {
          m = -1;
          break;
        }
        i2 -= localb1.z;
        i1 += 1;
        m = i3;
      }
      break label122;
      if (k == -1)
      {
        localc.x = -1;
        localc.y = -1;
        localc.width = 0;
        localc.height = 0;
      }
      while ((localc.x < 0) || (localc.y < 0))
      {
        paramRect.setEmpty();
        AppMethodBeat.o(115958);
        return;
        localb1 = this.bKz.yt();
        localb1.x = localc.x;
        localb1.y = (localc.y + paramInt2);
        localb1.z = paramInt1;
        this.mNodes.add(k, localb1);
        c.b localb2;
        for (i = k + 1; i < this.mNodes.size(); i = i - 1 + 1)
        {
          localb1 = (c.b)this.mNodes.get(i);
          localb2 = (c.b)this.mNodes.get(i - 1);
          if (localb1.x >= localb2.x + localb2.z) {
            break;
          }
          j = localb2.x;
          j = localb2.z + j - localb1.x;
          localb1.x += j;
          localb1.z -= j;
          if (localb1.z > 0) {
            break;
          }
          localb1 = (c.b)this.mNodes.remove(i);
          this.bKz.a(localb1);
        }
        for (i = 0; i < this.mNodes.size() - 1; i = j + 1)
        {
          localb1 = (c.b)this.mNodes.get(i);
          localb2 = (c.b)this.mNodes.get(i + 1);
          j = i;
          if (localb1.y == localb2.y)
          {
            j = localb1.z;
            localb2.z += j;
            localb1 = (c.b)this.mNodes.remove(i + 1);
            this.bKz.a(localb1);
            j = i - 1;
          }
        }
        this.bKA += paramInt1 * paramInt2;
      }
      paramRect.set(localc.x, localc.y, localc.x + paramInt1 - 1, localc.y + paramInt2 - 1);
      AppMethodBeat.o(115958);
      return;
    }
  }
  
  public final void init(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115957);
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    reset();
    AppMethodBeat.o(115957);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(115959);
    this.bKA = 0;
    this.bKz.c(this.mNodes);
    c.b localb = this.bKz.yt();
    localb.fK(this.mWidth - 2);
    this.mNodes.add(localb);
    AppMethodBeat.o(115959);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.k
 * JD-Core Version:    0.7.0.1
 */