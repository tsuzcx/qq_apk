package com.tencent.mm.plugin.dbbackup.a;

import android.database.Cursor;
import com.tencent.wcdb.repair.RepairKit.Callback;

final class a$1
  implements RepairKit.Callback
{
  private int iNQ = 0;
  private boolean iNR = false;
  private int xL = 0;
  
  a$1(a parama, int[] paramArrayOfInt) {}
  
  public final int onProgress(String paramString, int paramInt, Cursor paramCursor)
  {
    if (this.iNQ == 0) {
      if (paramString.equalsIgnoreCase("message"))
      {
        this.iNQ = paramInt;
        paramInt = this.xL;
        this.xL = (paramInt + 1);
        if (paramInt % 1000 == 0) {
          a.b(this.iNT, new Integer[] { Integer.valueOf(2), Integer.valueOf(this.xL - 1), Integer.valueOf(a.a(this.iNT)) });
        }
        paramString = this.iNS;
        paramString[0] += 1;
      }
    }
    do
    {
      return 0;
      if (this.iNQ == paramInt) {
        break;
      }
    } while (this.iNR);
    this.iNR = true;
    a.a(this.iNT, new Integer[] { Integer.valueOf(3) });
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.a.a.1
 * JD-Core Version:    0.7.0.1
 */