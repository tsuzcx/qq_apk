package com.tencent.mm.autogen.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.ark;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import java.util.List;

public final class ht
  extends IEvent
{
  public a hIR;
  public b hIS;
  
  public ht()
  {
    this((byte)0);
  }
  
  private ht(byte paramByte)
  {
    AppMethodBeat.i(127405);
    this.hIR = new a();
    this.hIS = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(127405);
  }
  
  public static final class a
  {
    public Context context;
    public String desc;
    public long hDn;
    public arv hDt;
    public p hEi;
    public arf hIT;
    public Intent hIU;
    public MStorage.IOnStorageChange hIV;
    public Runnable hIW;
    public String hIX;
    public int hIY = 0;
    public int hIZ = 0;
    public String hJa;
    public String hJb;
    public arx hJc;
    public MMHandler handler;
    public String path;
    public String title;
    public String toUser;
    public int type = 0;
  }
  
  public static final class b
  {
    public List dcC;
    public ark hJd;
    public ISQLiteDatabase hJe;
    public List hJf;
    public boolean hJg = false;
    public boolean hJh = false;
    public boolean hJi = false;
    public double hJj = 0.0D;
    public String hJk;
    public String path;
    public int ret = -1;
    public String thumbPath;
    public String thumbUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ht
 * JD-Core Version:    0.7.0.1
 */