package com.tencent.mm.plugin.appbrand.widget.desktop.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import java.io.File;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/DynamicBackgroundManager;", "", "()V", "init", "", "context", "Landroid/content/Context;", "plugin-appbrand-integration_release"})
public final class b
{
  public static final b myz;
  
  static
  {
    AppMethodBeat.i(51420);
    myz = new b();
    AppMethodBeat.o(51420);
  }
  
  public static void init(Context paramContext)
  {
    AppMethodBeat.i(51419);
    k.h(paramContext, "context");
    Object localObject = com.tencent.mm.dynamicbackground.a.b.fMj;
    k.h(paramContext, "context");
    localObject = new File(com.tencent.mm.dynamicbackground.a.b.cm(paramContext));
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    com.tencent.mm.dynamicbackground.a.b.i(paramContext, "scene_shaderf.glsl", com.tencent.mm.dynamicbackground.a.b.cm(paramContext) + "scene_shaderf.glsl");
    com.tencent.mm.dynamicbackground.a.b.i(paramContext, "scene_shaderv.glsl", com.tencent.mm.dynamicbackground.a.b.cm(paramContext) + "scene_shaderv.glsl");
    com.tencent.mm.dynamicbackground.a.b.i(paramContext, "frag_framebuffer_plane.glsl", com.tencent.mm.dynamicbackground.a.b.cm(paramContext) + "frag_framebuffer_plane.glsl");
    com.tencent.mm.dynamicbackground.a.b.i(paramContext, "vertex_framebuffer_plane.glsl", com.tencent.mm.dynamicbackground.a.b.cm(paramContext) + "vertex_framebuffer_plane.glsl");
    com.tencent.mm.dynamicbackground.a.b.i(paramContext, "texture_vertex_shader.glsl", com.tencent.mm.dynamicbackground.a.b.cm(paramContext) + "texture_vertex_shader.glsl");
    com.tencent.mm.dynamicbackground.a.b.i(paramContext, "texture_fragment_shader.glsl", com.tencent.mm.dynamicbackground.a.b.cm(paramContext) + "texture_fragment_shader.glsl");
    com.tencent.mm.dynamicbackground.a.b.i(paramContext, "bg_gradient_vertex_shader.glsl", com.tencent.mm.dynamicbackground.a.b.cm(paramContext) + "bg_gradient_vertex_shader.glsl");
    com.tencent.mm.dynamicbackground.a.b.i(paramContext, "bg_gradient_fragment_shader.glsl", com.tencent.mm.dynamicbackground.a.b.cm(paramContext) + "bg_gradient_fragment_shader.glsl");
    AppMethodBeat.o(51419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a.b
 * JD-Core Version:    0.7.0.1
 */