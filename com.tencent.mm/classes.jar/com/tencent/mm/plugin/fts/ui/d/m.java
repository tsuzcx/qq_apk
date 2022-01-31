package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.b;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.z;
import java.util.HashSet;
import java.util.HashSet<Ljava.lang.String;>;
import java.util.Iterator;
import java.util.List;

public final class m
  extends com.tencent.mm.plugin.fts.ui.a
{
  private boolean kEn = false;
  
  public m(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
    paramb = (String)g.DP().Dz().get(6, null);
    if ((paramb != null) && (paramb.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.kEn = bool;
      this.kEn &= bk.fV(paramContext);
      return;
    }
  }
  
  protected final com.tencent.mm.plugin.fts.a.a.a a(ah paramah, HashSet<String> paramHashSet)
  {
    i locali = new i();
    int[] arrayOfInt;
    if (this.kEn)
    {
      arrayOfInt = new int[6];
      int[] tmp22_21 = arrayOfInt;
      tmp22_21[0] = 131072;
      int[] tmp27_22 = tmp22_21;
      tmp27_22[1] = 131075;
      int[] tmp32_27 = tmp27_22;
      tmp32_27[2] = 131073;
      int[] tmp37_32 = tmp32_27;
      tmp37_32[3] = 131074;
      int[] tmp42_37 = tmp37_32;
      tmp42_37[4] = 262144;
      int[] tmp47_42 = tmp42_37;
      tmp47_42[5] = 131076;
      tmp47_42;
    }
    for (;;)
    {
      locali.kxa = arrayOfInt;
      locali.kxc = 3;
      locali.kxf = this;
      locali.handler = paramah;
      locali.scene = 0;
      locali.kxd = paramHashSet;
      if (!this.bVk.startsWith("@@")) {
        break;
      }
      locali.bVk = this.bVk.substring(2);
      return ((n)g.t(n.class)).search(10000, locali);
      arrayOfInt = new int[4];
      int[] tmp138_137 = arrayOfInt;
      tmp138_137[0] = 131072;
      int[] tmp143_138 = tmp138_137;
      tmp143_138[1] = 131075;
      int[] tmp148_143 = tmp143_138;
      tmp148_143[2] = 262144;
      int[] tmp153_148 = tmp148_143;
      tmp153_148[3] = 131076;
      tmp153_148;
    }
    locali.bVk = this.bVk;
    return ((n)g.t(n.class)).search(1, locali);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    int i = paramInt - parama.kxK - 1;
    l locall;
    com.tencent.mm.plugin.fts.ui.a locala;
    if ((i < parama.kxO.size()) && (i >= 0))
    {
      locall = (l)parama.kxO.get(i);
      if (locall.type == 131075) {
        locala = (com.tencent.mm.plugin.fts.ui.a)((n)g.t(n.class)).createFTSUIUnit(48, this.context, this.kxI, this.kxJ);
      }
    }
    for (;;)
    {
      if (locala != null) {}
      for (parama = locala.a(locall.type, paramInt, locall, parama);; parama = null)
      {
        if (parama != null) {
          parama.kxW = (i + 1);
        }
        return parama;
        if ((locall.type == 131072) || (locall.type == 131073) || (locall.type == 131074))
        {
          locala = (com.tencent.mm.plugin.fts.ui.a)((n)g.t(n.class)).createFTSUIUnit(32, this.context, this.kxI, this.kxJ);
          break;
        }
        if (locall.type == 262144)
        {
          locala = (com.tencent.mm.plugin.fts.ui.a)((n)g.t(n.class)).createFTSUIUnit(64, this.context, this.kxI, this.kxJ);
          break;
        }
        if (locall.type != 131076) {
          break label276;
        }
        locala = (com.tencent.mm.plugin.fts.ui.a)((n)g.t(n.class)).createFTSUIUnit(96, this.context, this.kxI, this.kxJ);
        break;
      }
      label276:
      locala = null;
    }
  }
  
  protected final void a(j paramj, HashSet<String> paramHashSet)
  {
    Object localObject = paramj.kxh.iterator();
    while (((Iterator)localObject).hasNext()) {
      paramHashSet.add(((l)((Iterator)localObject).next()).kwg);
    }
    if (bA(paramj.kxh))
    {
      e.a locala = new e.a();
      locala.businessType = -8;
      localObject = paramj.kxh;
      paramHashSet = (HashSet<String>)localObject;
      if (b.bA((List)localObject))
      {
        paramHashSet = (HashSet<String>)localObject;
        if (((List)localObject).size() > 3) {
          paramHashSet = ((List)localObject).subList(0, 3);
        }
      }
      locala.kxO = paramHashSet;
      locala.kxN = false;
      locala.kwi = paramj.kwi;
      this.kzW.add(locala);
    }
    d.bz(paramj.kxh);
  }
  
  public final int getType()
  {
    return 16;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d.m
 * JD-Core Version:    0.7.0.1
 */