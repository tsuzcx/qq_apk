package com.tencent.mm.f.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.anr;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import java.util.List;

public final class hi
  extends IEvent
{
  public a fEb;
  public b fEc;
  
  public hi()
  {
    this((byte)0);
  }
  
  private hi(byte paramByte)
  {
    AppMethodBeat.i(127405);
    this.fEb = new a();
    this.fEc = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(127405);
  }
  
  public static final class a
  {
    public Context context;
    public String desc;
    public anm fEd;
    public Intent fEe;
    public MStorage.IOnStorageChange fEf;
    public Runnable fEg;
    public String fEh;
    public int fEi = 0;
    public int fEj = 0;
    public String fEk;
    public String fEl;
    public aoe fEm;
    public long fyE;
    public aoc fyK;
    public q fzz;
    public MMHandler handler;
    public String path;
    public String title;
    public String toUser;
    public int type = 0;
  }
  
  public static final class b
  {
    public List biI;
    public anr fEn;
    public ISQLiteDatabase fEo;
    public List fEp;
    public boolean fEq = false;
    public boolean fEr = false;
    public boolean fEs = false;
    public double fEt = 0.0D;
    public String fEu;
    public String path;
    public int ret = -1;
    public String thumbPath;
    public String thumbUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.hi
 * JD-Core Version:    0.7.0.1
 */