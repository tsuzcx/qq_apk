package a.j.b.a.c.a;

import a.f.b.t;
import a.f.b.v;
import a.g;
import a.j.b.a.c.b.aa;
import a.j.b.a.c.b.e;
import a.j.b.a.c.b.y;
import a.j.b.a.c.c.a.c;
import a.j.b.a.c.i.e.h;
import a.l.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
{
  public static final i.b BUb;
  private final a.f BTS;
  private final i.a BTT;
  private final i.a BTU;
  private final i.a BTV;
  private final i.a BTW;
  private final i.a BTX;
  private final i.a BTY;
  private final i.a BTZ;
  private final aa BUa;
  
  static
  {
    AppMethodBeat.i(119108);
    eOJ = new a.j.k[] { (a.j.k)v.a(new t(v.aG(i.class), "kotlinReflectScope", "getKotlinReflectScope()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;")), (a.j.k)v.a(new t(v.aG(i.class), "kClass", "getKClass()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (a.j.k)v.a(new t(v.aG(i.class), "kProperty0", "getKProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (a.j.k)v.a(new t(v.aG(i.class), "kProperty1", "getKProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (a.j.k)v.a(new t(v.aG(i.class), "kProperty2", "getKProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (a.j.k)v.a(new t(v.aG(i.class), "kMutableProperty0", "getKMutableProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (a.j.k)v.a(new t(v.aG(i.class), "kMutableProperty1", "getKMutableProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), (a.j.k)v.a(new t(v.aG(i.class), "kMutableProperty2", "getKMutableProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")) };
    BUb = new i.b((byte)0);
    AppMethodBeat.o(119108);
  }
  
  public i(y paramy, aa paramaa)
  {
    AppMethodBeat.i(119110);
    this.BUa = paramaa;
    this.BTS = g.a(a.k.BLU, (a.f.a.a)new i.c(paramy));
    this.BTT = new i.a(1);
    this.BTU = new i.a(1);
    this.BTV = new i.a(2);
    this.BTW = new i.a(3);
    this.BTX = new i.a(1);
    this.BTY = new i.a(2);
    this.BTZ = new i.a(3);
    AppMethodBeat.o(119110);
  }
  
  public final e ecr()
  {
    AppMethodBeat.i(119109);
    Object localObject1 = this.BTT;
    Object localObject2 = eOJ[1];
    a.f.b.j.q(this, "types");
    a.f.b.j.q(localObject2, "property");
    localObject2 = m.capitalize(((a.j.k)localObject2).getName());
    int i = ((i.a)localObject1).BUc;
    a.j.b.a.c.f.f localf = a.j.b.a.c.f.f.ayT((String)localObject2);
    a.f.b.j.p(localf, "Name.identifier(className)");
    localObject2 = ((h)this.BTS.getValue()).c(localf, (a.j.b.a.c.c.a.a)c.CbA);
    localObject1 = localObject2;
    if (!(localObject2 instanceof e)) {
      localObject1 = null;
    }
    localObject2 = (e)localObject1;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.BUa.a(new a.j.b.a.c.f.a(j.ecs(), localf), a.a.j.listOf(Integer.valueOf(i)));
    }
    AppMethodBeat.o(119109);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     a.j.b.a.c.a.i
 * JD-Core Version:    0.7.0.1
 */