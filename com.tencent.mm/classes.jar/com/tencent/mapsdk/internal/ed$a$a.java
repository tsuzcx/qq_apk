package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class ed$a$a
  extends ec.c
{
  @Json(name="theme")
  public b a;
  @Json(name="control")
  public a b;
  
  public final boolean a()
  {
    AppMethodBeat.i(222750);
    if ((super.a()) && (this.a != null))
    {
      Object localObject = this.a;
      if (((b)localObject).a != null)
      {
        localObject = ((b)localObject).a;
        if (((ed.a.a.b.b)localObject).a != null)
        {
          localObject = ((ed.a.a.b.b)localObject).a;
          if ((((ed.a.a.b.a)localObject).a > 0) && (((ed.a.a.b.a)localObject).b != null))
          {
            ec.c.e locale = ((ed.a.a.b.a)localObject).b;
            if ((locale.a != null) && (locale.a.size() > 0) && (locale.b != null) && (locale.b.size() > 0))
            {
              i = 1;
              if ((i == 0) || (((ed.a.a.b.a)localObject).c == null)) {
                break label188;
              }
              if (((ed.a.a.b.a)localObject).c.c < 0.0D) {
                break label183;
              }
              i = 1;
              label132:
              if (i == 0) {
                break label188;
              }
              i = 1;
              label138:
              if (i == 0) {
                break label193;
              }
              i = 1;
              label144:
              if (i == 0) {
                break label198;
              }
            }
          }
        }
      }
      label183:
      label188:
      label193:
      label198:
      for (int i = 1;; i = 0)
      {
        if ((i == 0) || (this.b == null) || (!this.b.a())) {
          break label203;
        }
        AppMethodBeat.o(222750);
        return true;
        i = 0;
        break;
        i = 0;
        break label132;
        i = 0;
        break label138;
        i = 0;
        break label144;
      }
    }
    label203:
    AppMethodBeat.o(222750);
    return false;
  }
  
  public static final class a
    extends ec.c.a
  {
    @Json(name="maxIntensity")
    public double a;
    @Json(name="minIntensity")
    public double b;
    @Json(name="enable3D")
    public boolean c;
    @Json(name="heightRange")
    public List<Double> d;
    @Json(name="animated")
    public boolean e;
    
    public final boolean a()
    {
      AppMethodBeat.i(222620);
      if ((super.a()) && (this.d != null) && (this.d.size() > 0))
      {
        AppMethodBeat.o(222620);
        return true;
      }
      AppMethodBeat.o(222620);
      return false;
    }
  }
  
  public static final class b
    extends JsonComposer
  {
    @Json(name="standard")
    public b a;
    
    private boolean a()
    {
      AppMethodBeat.i(222474);
      if (this.a != null)
      {
        Object localObject = this.a;
        if (((b)localObject).a != null)
        {
          localObject = ((b)localObject).a;
          if ((((a)localObject).a > 0) && (((a)localObject).b != null))
          {
            ec.c.e locale = ((a)localObject).b;
            if ((locale.a != null) && (locale.a.size() > 0) && (locale.b != null) && (locale.b.size() > 0))
            {
              i = 1;
              if ((i == 0) || (((a)localObject).c == null)) {
                break label146;
              }
              if (((a)localObject).c.c < 0.0D) {
                break label141;
              }
              i = 1;
              label113:
              if (i == 0) {
                break label146;
              }
              i = 1;
              label119:
              if (i == 0) {
                break label151;
              }
            }
          }
        }
        label141:
        label146:
        label151:
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label156;
          }
          AppMethodBeat.o(222474);
          return true;
          i = 0;
          break;
          i = 0;
          break label113;
          i = 0;
          break label119;
        }
      }
      label156:
      AppMethodBeat.o(222474);
      return false;
    }
    
    public static final class a
      extends ec.c.c
    {
      @Json(name="radius")
      public int a;
      @Json(name="gradient")
      public ec.c.e b;
      @Json(name="animation")
      public ec.c.d c;
      
      private boolean a()
      {
        AppMethodBeat.i(223396);
        if ((this.a > 0) && (this.b != null))
        {
          ec.c.e locale = this.b;
          if ((locale.a != null) && (locale.a.size() > 0) && (locale.b != null) && (locale.b.size() > 0))
          {
            i = 1;
            if ((i == 0) || (this.c == null)) {
              break label110;
            }
            if (this.c.c < 0.0D) {
              break label105;
            }
          }
          label105:
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label110;
            }
            AppMethodBeat.o(223396);
            return true;
            i = 0;
            break;
          }
        }
        label110:
        AppMethodBeat.o(223396);
        return false;
      }
    }
    
    public static final class b
      extends JsonComposer
    {
      @Json(name="defaultStyle")
      public ed.a.a.b.a a;
      
      private boolean a()
      {
        AppMethodBeat.i(223516);
        if (this.a != null)
        {
          ed.a.a.b.a locala = this.a;
          if ((locala.a > 0) && (locala.b != null))
          {
            ec.c.e locale = locala.b;
            if ((locale.a != null) && (locale.a.size() > 0) && (locale.b != null) && (locale.b.size() > 0))
            {
              i = 1;
              if ((i == 0) || (locala.c == null)) {
                break label128;
              }
              if (locala.c.c < 0.0D) {
                break label123;
              }
              i = 1;
              label101:
              if (i == 0) {
                break label128;
              }
            }
          }
          label128:
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label133;
            }
            AppMethodBeat.o(223516);
            return true;
            i = 0;
            break;
            label123:
            i = 0;
            break label101;
          }
        }
        label133:
        AppMethodBeat.o(223516);
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ed.a.a
 * JD-Core Version:    0.7.0.1
 */