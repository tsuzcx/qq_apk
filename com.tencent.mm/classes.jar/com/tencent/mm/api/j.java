package com.tencent.mm.api;

import android.content.Intent;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.protobuf.bxf;
import com.tencent.mm.protocal.protobuf.bxh;
import java.util.ArrayList;

public abstract interface j
  extends a
{
  public abstract void a(Intent paramIntent, bxf parambxf, int paramInt);
  
  public abstract void a(Intent paramIntent, bxh parambxh, int paramInt);
  
  public abstract boolean dk(String paramString);
  
  public abstract ArrayList<String> dl(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.api.j
 * JD-Core Version:    0.7.0.1
 */