package androidx.compose.ui.e;

import android.graphics.Shader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"ShaderBrush", "Landroidx/compose/ui/graphics/ShaderBrush;", "shader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "ui-graphics_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class t
{
  public static final aw b(Shader paramShader)
  {
    AppMethodBeat.i(205933);
    s.u(paramShader, "shader");
    paramShader = (aw)new a(paramShader);
    AppMethodBeat.o(205933);
    return paramShader;
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/ui/graphics/BrushKt$ShaderBrush$1", "Landroidx/compose/ui/graphics/ShaderBrush;", "createShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "size", "Landroidx/compose/ui/geometry/Size;", "createShader-uvyYCjk", "(J)Landroid/graphics/Shader;", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends aw
  {
    a(Shader paramShader) {}
    
    public final Shader X(long paramLong)
    {
      return this.awB;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.t
 * JD-Core Version:    0.7.0.1
 */