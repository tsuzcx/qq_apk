package com.tencent.mm.plugin.luckymoney.appbrand.ui.detail;

import android.content.Intent;
import com.tencent.mm.protocal.protobuf.aty;
import com.tencent.mm.protocal.protobuf.bji;
import com.tencent.mm.protocal.protobuf.bqs;
import java.util.List;

public abstract interface b
  extends com.tencent.mm.plugin.luckymoney.appbrand.ui.b
{
  public abstract void a(bji parambji);
  
  public abstract void a(bqs parambqs);
  
  public abstract void ad(Intent paramIntent);
  
  public abstract void ch(List<aty> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.b
 * JD-Core Version:    0.7.0.1
 */